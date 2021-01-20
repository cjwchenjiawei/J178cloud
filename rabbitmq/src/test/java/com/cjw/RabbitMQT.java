package com.cjw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.cjw.RabbitMain.class)
public class RabbitMQT {

    @Autowired
        RabbitTemplate rabbitTemplate;

    @Test
    public void send1(){
        String str = "hello cjw";
        rabbitTemplate.convertAndSend("directExchange","j178.one",str);
    }

    @Test
    public void send2(){
        String str = "hello cjw";
        rabbitTemplate.convertAndSend("topicExchange","topic.cc",str);
    }

    @Test
    public void send3(){
        String str = "hello cjw";
        rabbitTemplate.convertAndSend("fanoutExchange",null,str+"ff");
    }
}
