package com.cjw.client;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain.class,args);
    }

@RabbitListener(queues = "one")
    public void getMQ1(String str){
        System.out.println(str);
    }

@RabbitListener(queues = "two")
    public void getMQ2(String str){
        System.out.println(str);
    }

@RabbitListener(queues = "three")
    public void getMQ3(String str){
        System.out.println(str);
    }

@RabbitListener(queues = "four")
    public void getMQ4(String str){
        System.out.println(str);
    }
}

