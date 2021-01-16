package com.cjw.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjw.boot.mapper")
public class BootMain {
    public static void main(String[] args) {
        SpringApplication.run(BootMain.class,args);
    }
}
