package com.cjw.redis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjw.redis.config.RedisCacheUtil;
import com.cjw.util.StringUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjw.redis.model.User;
import com.cjw.redis.mapper.UserMapper;
import com.cjw.redis.service.UserService;
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Autowired
    private RedissonClient redisson;


    @Override
    public List<User> findUserList(String username, String password) {

        //查询缓存
        //1、组装KEY
        String key = username+"_"+password;
        //布隆算法
        if (!StringUtil.bloomFilter.mightContain(key)){
            return null;
        }
        //2、查询缓存
        List<User> list = (List<User>) redisCacheUtil.get(key);
        if (list==null||list.isEmpty()){
            //防止缓存击穿

            //1、获取锁
            //2、如果获取的锁-->true,就去查询数据库  ，把数据放入缓存
            //3、如果没有拿到锁，休眠400毫秒，醒后去查询缓存。如果缓存没有继续上一步



            //缓存中不存在
            list = this.list(new QueryWrapper<User>().eq("username", username).eq("password", password));
            //放入缓存
            //防止缓存雪崩
            long time = System.currentTimeMillis() % 60;
            if (time<30){
                time = 30;
            }
            System.out.println("time = " + time);
            if (list==null){
                redisCacheUtil.set(key,null,StringUtil.CACHE_NULL);
            }else{
                redisCacheUtil.set(key,list,time);
            }
        }


        return list;
    }

    //防治击穿
    @Override
    public List<User> findUserList2(String username, String password) {

        //查询缓存
        //1、组装KEY
        String key = username+"_"+password;
        //布隆算法
        if (!StringUtil.bloomFilter.mightContain(key)){
            return null;
        }
        //2、查询缓存
        List<User> list = (List<User>) redisCacheUtil.get(key);
        if (list==null||list.isEmpty()){
            //防止缓存击穿

            //1、获取锁
            //2、如果获取的锁-->true,就去查询数据库  ，把数据放入缓存
            //3、如果没有拿到锁，休眠400毫秒，醒后去查询缓存。如果缓存没有继续上一步

            /**
             * 得到一把公共锁
             */
            RLock lock = redisson.getLock("j178");
            try {
                if(lock.tryLock(4,2,TimeUnit.SECONDS)){
                    //缓存中不存在
                    list = this.list(new QueryWrapper<User>().eq("username", username).eq("password", password));
                    //放入缓存
                    //防止缓存雪崩
                    long time = System.currentTimeMillis() % 60;
                    if (time<30){
                        time = 30;
                    }
                    System.out.println("time = " + time);
                    if (list==null){
                        redisCacheUtil.set(key,null,StringUtil.CACHE_NULL);
                    }else{
                        redisCacheUtil.set(key,list,time);
                    }
                }else {
                    Thread.sleep(400);
                    return this.findUserList2(username,password);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return list;
    }
}
