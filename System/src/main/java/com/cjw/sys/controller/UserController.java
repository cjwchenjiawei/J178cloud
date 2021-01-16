package com.cjw.sys.controller;

import com.cjw.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("userInfoOne")
    public String userInfoOne(){
        return userService.userInfo(1);
    }

    @GetMapping("userInfoTwo")
    public String userInfoTwo(){
        return userService.userInfo(2);
    }

    @GetMapping("userInfoThree")
    public String userInfoThree(){
        return userService.userInfo(3);
    }

    @GetMapping("scoreList")
    public String scoreList(){
        return userService.scoreList();
    }
}
