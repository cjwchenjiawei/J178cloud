package com.cjw.controller;

import com.cjw.service.IAckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AckController {

    @Autowired
    private IAckService ackService;

    @GetMapping("send/{tag}")
    public String send(@PathVariable("tag") String tag){
        ackService.send(tag);
        return "ok";
    }
}
