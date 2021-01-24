package com.cjw.movieGuest.controller;

import com.cjw.dto.MovieOrderDto;
import com.cjw.dto.UserDto;
import com.cjw.movieGuest.model.GuestOrder;
import com.cjw.movieGuest.service.GuestOrderService;
import com.cjw.movieGuest.service.OrderService;
import com.cjw.movieGuest.service.TestService;
import com.cjw.util.StringUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GuestOrderService guestOrderService;
    @Autowired
    private TestService testService;

    @PostMapping("/guest/buy")
    public String buy(@RequestParam("movieId")Integer movieId){
        System.out.println("movieId = " + movieId);
        return orderService.buy(movieId, 1);
    }

    @PutMapping("/order/updateState1")
    public String updateState1(@RequestBody MovieOrderDto movieOrderDto) {
        long orderNumber = movieOrderDto.getOrderNumber();
        Integer n = orderService.updateState1(orderNumber);
        if (n > 0) {
            return StringUtil.UPDATE_OK;
        } else {
            return StringUtil.UPDATE_ERROR;
        }
    }

    @PutMapping("/order/updateState2")
    public String updateState2(@RequestBody MovieOrderDto movieOrderDto) {
        long orderNumber = movieOrderDto.getOrderNumber();
        Integer n = orderService.updateState2(orderNumber);
        if (n > 0) {
            return StringUtil.UPDATE_OK;
        } else {
            return StringUtil.UPDATE_ERROR;
        }
    }

    @GetMapping("/guest/orderList")
    public List<GuestOrder>list(){
        return guestOrderService.orderList();
    }

    @GetMapping("order")
    public String orderInfo(){
        return testService.hello();
    }

    @GetMapping("order1")
    public String orderInfo1(){
        return testService.hello(1);
    }

    @GetMapping("order2")
    public UserDto orderInfo2(){
        UserDto userDto = new UserDto();
        userDto.setUsername("赵云");
        userDto.setPassword("123456");
        return testService.helloObj(userDto);
    }

}
