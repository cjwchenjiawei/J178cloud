package com.cjw.power.controller;

import com.cjw.power.mapper.UserMapper;
import com.cjw.dto.UserDto;
import com.cjw.jwt.JwtUtil;
import com.cjw.power.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerController {
@Autowired
private UserMapper userMapper;
    @GetMapping("tokenInfo/{username}/{password}")
    public String tokenInfo(@PathVariable("username") String username,@PathVariable("password") String password){
        User user = userMapper.selectOneByUsernameAndPassword(username, password);
        if (user!=null){
            UserDto userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setPassword(password);
            userDto.setPower(1);
            return JwtUtil.createToken(userDto);
        }
        return null;
    }
}
