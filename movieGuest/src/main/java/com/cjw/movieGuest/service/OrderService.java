package com.cjw.movieGuest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderService {

    public String buy(Integer movieId,Integer number);


    Integer updateState(long orderNumber);
}
