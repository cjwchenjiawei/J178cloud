package com.cjw.movieGuest.service;

import com.cjw.dto.MovieOrderDto;
import com.cjw.dto.UserDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "orderSys" ,fallback = HystrixTestService.class)
public interface TestService {

    @GetMapping("/client/info")
    public  String info();

    @PostMapping("/order/buy")
    public String buy (@RequestBody MovieOrderDto movieOrderDto);

    @GetMapping("/hello")
    public String hello();

    @GetMapping("/hello/{tag}")
    public String hello(@PathVariable("tag") Integer tag);

    @PostMapping("/helloObj")
    public UserDto helloObj(@RequestBody UserDto userDto);
}
