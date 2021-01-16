package com.cjw.boot.controller;

import com.cjw.boot.model.User;
import com.cjw.boot.service.UserService;
import com.cjw.boot.util.ResultVO;
import com.cjw.dto.UserDto;
import com.cjw.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{code}/{token}")
    public String login(@PathVariable("code") Integer code,@PathVariable("token") String token) throws InterruptedException {

        UserDto userDto = JwtUtil.verifierJwt(token);

        String str = "";
        Thread.sleep(1000);
        if (userDto!=null){
            switch(code){
                case 1:
                    str = "hello one";
                    break;
                case 2:
                    str = "hello two";
                    break;
            }
        }

        return str;
    }

    @PostMapping("loginPost")
    public UserDto login(@RequestBody UserDto userDto){
        System.out.println("userDto = " + userDto);
        userDto.setUsername("赵云");
        return  userDto;
    }


    @PostMapping("/register")
    public String register(User user,@RequestParam("fileName") MultipartFile file){
        System.out.println(user);
        String img = "http://127.0.0.1:8080/img/"+file.getOriginalFilename();
        System.out.println("img = " + img);
        user.setImg(img);
        Integer add = userService.add(user);
        if (add>0){
            return "注册成功";
        }else {
            return "注册失败";
        }
    }

    @GetMapping("/user/list")
    public ResultVO list(){
        List<User> list = userService.list();
        System.out.println("list = " + list);
        return ResultVO.success(list);
    }
}
