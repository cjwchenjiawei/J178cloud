package com.cjw.movieGuest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.cjw.movieGuest.mapper")
public class GuestMain {
    public static void main(String[] args) {
        SpringApplication.run(GuestMain.class,args);
    }
}
