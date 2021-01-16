package com.cjw.power;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjw.power.mapper")
public class PowerMain {
    public static void main(String[] args) {
        SpringApplication.run(PowerMain.class,args);
    }
}
