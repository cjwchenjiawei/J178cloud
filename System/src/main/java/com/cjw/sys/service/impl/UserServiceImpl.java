package com.cjw.sys.service.impl;

import com.cjw.dto.UserDto;
import com.cjw.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String scoreList() {
        String str = "";
        String urlToken = "http://127.0.0.1:8001/tokenInfo/zhangsan/111";
        String token = restTemplate.getForEntity(urlToken, String.class).getBody();
        String url = "http://127.0.0.1:8080/score/list/"+token;
        System.out.println("token = " + token);
        str = restTemplate.getForEntity(url,String.class).getBody();
        return str;
    }

    @Override
    public String userInfo(Integer tag) {
        String str = "";
        if (tag == 3){
            UserDto userDto = new UserDto();
            userDto.setUsername("马超");
            userDto.setPassword("123456");
            String url = "http://127.0.0.1:8080/loginPost";
            //RPC
            UserDto user=restTemplate.postForEntity(url,userDto,UserDto.class).getBody();
            str=user.getUsername();
        }else{
            //远程调用认证系统获取token
            String urlToken = "http://127.0.0.1:8001/tokenInfo/zhangsan/111";
            String token = restTemplate.getForEntity(urlToken, String.class).getBody();
            String url = "http://127.0.0.1:8080/login/"+tag+"/"+token;
            System.out.println("token = " + token);
            str = restTemplate.getForEntity(url,String.class).getBody();
        }
        return str;
    }
}
