package com.cjw.movieGuest.service;

import com.cjw.dto.MovieOrderDto;
import com.cjw.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movieOrder" ,url = "http://127.0.0.1:8003/")
public interface TestService {

    @PostMapping("/order/buy")
    public String buy (@RequestBody MovieOrderDto movieOrderDto);

    @GetMapping("/hello")
    public String hello();

    @GetMapping("/hello/{tag}")
    public String hello(@PathVariable("tag") Integer tag);

    @PostMapping("/helloObj")
    public UserDto helloObj(@RequestBody UserDto userDto);
}
