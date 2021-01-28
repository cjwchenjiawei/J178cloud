package com.cjw.nginx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NginxController {
    @GetMapping("nginx")
    public String nginx(){
        return "服务器2";
    }
}
