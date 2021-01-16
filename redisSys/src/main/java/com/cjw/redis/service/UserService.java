package com.cjw.redis.service;

import com.cjw.redis.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User>{
    List<User> findUserList(String username, String password);

    List<User> findUserList2(String username, String password);


}
