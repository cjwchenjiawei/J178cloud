package com.cjw.power.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjw.power.mapper.UserMapper;
import com.cjw.power.model.User;
import com.cjw.power.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
