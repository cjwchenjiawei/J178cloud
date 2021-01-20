package com.cjw.cinema.service;

import com.cjw.dto.MovieOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "guestOrderService" ,url = "http://127.0.0.1:8002/")
public interface GuestOrderService {
    @PutMapping("/order/updateState")
    public String updateState(@RequestBody MovieOrderDto movieOrderDto);
}
