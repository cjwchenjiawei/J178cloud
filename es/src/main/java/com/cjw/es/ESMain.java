package com.cjw.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.cjw.es.mapper")
public class ESMain {
    public static void main(String[] args) {
        SpringApplication.run(ESMain.class,args);
    }
}
