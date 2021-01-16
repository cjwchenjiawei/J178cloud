package com.cjw.redis.controller;

import com.cjw.jedis.util.JedisDb;
import com.cjw.jedis.util.SerializeUtil;
import com.cjw.redis.config.RedisCacheUtil;
import com.cjw.redis.mapper.RouteMapper;
import com.cjw.redis.mapper.UserMapper;
import com.cjw.redis.model.Route;
import com.cjw.redis.model.User;
import com.cjw.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private RedisCacheUtil redisCacheUtil;
    @Autowired
    private UserService userService;

    @GetMapping("/user/routeList/{username}")
    public String getRouteList(@PathVariable("username") String username){
        User user = (User)redisCacheUtil.get(username);

        if (user == null) {
            User u = userMapper.findOneByUsername(username);
            List<Route> routeList = routeMapper.findAllByFkUserId(u.getId());
            u.setRouteList(routeList);
            redisCacheUtil.set(u.getUsername(),u,10);
            User o = (User) redisCacheUtil.get(u.getUsername());
            System.out.println(o);
            return o.toString();
        }
        return user.toString();
    }

    @GetMapping("userList/{username}/{password}")
    public List<User>userList(@PathVariable("username")String username,@PathVariable("password")String password){
        return userService.findUserList(username,password);

    }

    @GetMapping("userList2/{username}/{password}")
    public List<User>userList2(@PathVariable("username")String username,@PathVariable("password")String password){
        return userService.findUserList2(username,password);

    }
}
