package com.cjw.boot.service;

import com.cjw.boot.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{

    Integer add(User user);
}
