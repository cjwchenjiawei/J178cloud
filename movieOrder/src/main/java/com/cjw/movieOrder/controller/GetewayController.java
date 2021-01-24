package com.cjw.movieOrder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class GetewayController {

    @GetMapping("/info")
    public  String info(){
        return "order info";
    }
}
