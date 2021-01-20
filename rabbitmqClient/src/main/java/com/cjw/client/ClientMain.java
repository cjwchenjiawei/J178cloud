package com.cjw.client;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

@SpringBootApplication
public class ClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain.class,args);
    }

@RabbitListener(queues = "one")
    public void getMQ1(String str, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){
    try {
        channel.basicAck(tag,false);
//        channel.basicNack(tag,false,true);
    } catch (IOException e) {
        e.printStackTrace();
    }
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

