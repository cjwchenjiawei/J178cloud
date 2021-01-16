package com.cjw.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SysConfig {

    //创建restTemplet交给spring 容器
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
