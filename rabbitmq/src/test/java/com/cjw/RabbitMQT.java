package com.cjw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.cjw.RabbitMain.class)
public class RabbitMQT {

    @Autowired
        RabbitTemplate rabbitTemplate;

    RabbitTemplate.ConfirmCallback callback=(CorrelationData correlationData, boolean b, String s)->{
        //获得MQ返回的唯一标志id
        String id=  correlationData.getId();
        System.out.println(id);
        System.out.println(b);
        System.out.println(s);
    };

    @Test
    public void send1(){
        String str = "hello cjw";

        //开启手动确认
        rabbitTemplate.setMandatory(true);//开启消息确认
        //绑定回调函数
        rabbitTemplate.setConfirmCallback(callback);
        //组装关联数据
        CorrelationData correlationData=new CorrelationData("1");
        rabbitTemplate.convertAndSend("directExchange","j178.one",str,correlationData);
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
