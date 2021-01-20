package com.cjw.cinema;

import com.cjw.cinema.model.MovieOrder;
import com.cjw.dto.MovieOrderDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@MapperScan("com.cjw.cinema.mapper")
public class CinemaMain {
    public static void main(String[] args) {
        SpringApplication.run(CinemaMain.class,args);
    }

//    @RabbitListener(queues = "order")
//    public void buy(MovieOrderDto movieOrderDto){
//        System.out.println(movieOrderDto);
//    }
}
