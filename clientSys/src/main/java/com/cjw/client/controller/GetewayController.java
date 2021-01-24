package com.cjw.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class GetewayController {

    @GetMapping("/info")
    public  String info(){
        int i=1/0;
        return "client info";
    }
}
