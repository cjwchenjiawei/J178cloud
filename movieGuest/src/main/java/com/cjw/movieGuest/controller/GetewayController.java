package com.cjw.movieGuest.controller;

import com.cjw.movieGuest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class GetewayController {

    @Autowired
    private TestService testService;

    @GetMapping("/info")
    public  String info(){
        return testService.info();
    }
}
