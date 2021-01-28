package com.cjw.cinema.service.impl;

import com.alibaba.fastjson.JSON;
import com.cjw.cinema.service.MovieStockService;
import com.cjw.cinema.util.StringUtil;
import com.cjw.dto.MovieOrderDto;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@ServerEndpoint("/socketService")
public class socketService {

    List<Session> sessionList=new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        sessionList.add(session);
        session.getBasicRemote().sendText("与后台已经建立连接");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        while (true){
            //一直往页面发送消息
            for(Session s:this.sessionList){
                if(null!=session&&session.isOpen()){
                    //获得集合中的数据
                    List<MovieOrderDto> list = StringUtil.list;
                    //把list转换为json格式的字符串
                    String str= JSON.toJSONString(list);
                    if(!list.isEmpty()){
                        s.getBasicRemote().sendText(str);
                    }

                }
            }
            Thread.sleep(500);
        }
    }
}
