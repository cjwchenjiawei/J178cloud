package com.cjw.boot.service.impl;

import com.cjw.boot.mapper.UserMapper;
import com.cjw.boot.model.User;
import com.cjw.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Integer add(User user) {
        return userMapper.insert(user);
    }
}
