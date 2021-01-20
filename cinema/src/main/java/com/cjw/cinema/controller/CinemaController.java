package com.cjw.cinema.controller;

import com.cjw.cinema.model.MovieOrder;
import com.cjw.cinema.model.MovieStock;
import com.cjw.cinema.service.MovieStockService;
import com.cjw.dto.MovieOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {
    @Autowired
    private MovieStockService movieStockService;

    @RabbitListener(queues = "order")
    @PutMapping("/order/updateStock")
    public void updateStock(MovieOrderDto movieOrderDto){
        System.out.println("movieOrderDto = " + movieOrderDto);
        movieStockService.updateStock(movieOrderDto);
    }

    @GetMapping("/movieStock/list")
    public List<MovieStock>list(){
        return movieStockService.stockList();
    }
}
