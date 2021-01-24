package com.cjw.movieOrder.service;

import com.cjw.dto.MovieOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service("guestOrderService")
@FeignClient("guestSys")
public interface GuestOrderService {

    @PutMapping("/order/updateState1")
    public String updateState1(@RequestBody MovieOrderDto movieOrderDto);

    @PutMapping("/order/updateState2")
    public String updateState2(@RequestBody MovieOrderDto movieOrderDto);


}
