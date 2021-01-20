package com.cjw.movieOrder.controller;

import com.cjw.dto.MovieOrderDto;
import com.cjw.dto.UserDto;
import com.cjw.movieOrder.model.MovieOrder;
import com.cjw.movieOrder.service.MovieOrderService;
import com.cjw.util.StringUtil;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private MovieOrderService movieOrderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/order/list")
    public List<MovieOrder> orderList(){
        return movieOrderService.orderList();
    }

    RabbitTemplate.ConfirmCallback callback=(CorrelationData correlationData, boolean b, String s)->{
        //获得MQ返回的唯一标志orderNum
        long id=  Long.parseLong(correlationData.getId());
        if (b){
            Integer n = movieOrderService.updateState1(id);
        }
    };

    @PostMapping("/order/buy")
    public String buy (@RequestBody MovieOrderDto movieOrderDto){
        System.out.println("movieOrderDto = " + movieOrderDto);
        MovieOrder movieOrder = new MovieOrder();
        movieOrder.setFkMovieId(movieOrderDto.getMovieId());
        movieOrder.setOrderNumber(movieOrderDto.getOrderNumber());
        movieOrder.setNumber(movieOrderDto.getNumber());
        movieOrder.setPrice(movieOrderDto.getPrice());
        movieOrder.setState(movieOrderDto.getState());
        boolean save = movieOrderService.save(movieOrder);
        if (save){
            System.out.println("movieOrder = " + movieOrder);
            movieOrderDto.setId(movieOrder.getId());
            //开启手动确认
            //开启消息确认
            rabbitTemplate.setMandatory(true);
            //绑定回调函数
            rabbitTemplate.setConfirmCallback(callback);
            //组装关联数据
            CorrelationData correlationData=new CorrelationData(String.valueOf(movieOrderDto.getOrderNumber()));
            rabbitTemplate.convertAndSend("directExchange","j178.order",movieOrderDto,correlationData);
            return StringUtil.BUY_OK;
        }else {
            return StringUtil.BUY_NO;
        }
    }

    @PutMapping("/order/updateState")
    public String updateState(@RequestBody MovieOrderDto movieOrderDto){
        long orderNumber = movieOrderDto.getOrderNumber();
        Integer n = movieOrderService.updateState2(orderNumber);
        if (n>0){
            return StringUtil.UPDATE_OK;
        }else {
            return StringUtil.UPDATE_ERROR;
        }
    }


    @GetMapping("hello")
    public String hello(){
        return "hello order";
    }

    @GetMapping("hello/{tag}")
    public String hello(@PathVariable("tag") Integer tag){
        if (tag == 1){
            return "hello order1";
        }else {
            return "hello order2";
        }
    }

    @PostMapping("helloObj")
    public UserDto helloObj(@RequestBody UserDto userDto){
        return userDto;
    }
}
