package com.cjw.service.impl;

import com.cjw.service.IAckService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AckServiceImpl implements IAckService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    RabbitTemplate.ConfirmCallback callback=(CorrelationData correlationData, boolean b, String s)->{
        //获得MQ返回的唯一标志orderNum
        String id=  correlationData.getId();
        System.out.println(id);
        System.out.println(b);
        System.out.println(s);
    };

    @Override
    public void send(String str) {

        //开启手动确认
        //开启消息确认
        rabbitTemplate.setMandatory(true);
        //绑定回调函数
        rabbitTemplate.setConfirmCallback(callback);
        //组装关联数据
        CorrelationData correlationData=new CorrelationData("1");

        rabbitTemplate.convertAndSend("directExchange","j178.one",str,correlationData);


    }
}
