package com.cjw.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjw.redis.mapper")
public class RedisMain {
    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class,args);
    }
}
