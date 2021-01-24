package com.cjw.cinema.service;

import com.cjw.dto.MovieOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient("orderSys")
public interface MovieOrderService {
    @PutMapping("/order/updateState")
    public String updateState(@RequestBody MovieOrderDto movieOrderDto);
}
