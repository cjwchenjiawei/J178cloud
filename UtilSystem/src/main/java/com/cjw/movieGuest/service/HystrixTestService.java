package com.cjw.movieGuest.service;

import com.cjw.dto.MovieOrderDto;
import com.cjw.dto.UserDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class HystrixTestService implements TestService{
    @Override
    public String info() {
        return "批量熔断处理";
    }

    @Override
    public String buy(MovieOrderDto movieOrderDto) {
        return null;
    }

    @Override
    public String hello() {
        return null;
    }

    @Override
    public String hello(Integer tag) {
        return null;
    }

    @Override
    public UserDto helloObj(UserDto userDto) {
        return null;
    }
}
