package com.cjw.movieGuest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//远程调用
@EnableDiscoveryClient//注册、配置
@RefreshScope//类似热部署
@EnableCircuitBreaker//熔断
@MapperScan("com.cjw.movieGuest.mapper")
public class GuestMain {
    public static void main(String[] args) {
        SpringApplication.run(GuestMain.class,args);
    }
}
