package com.cjw.movieGuest.service.impl;

import com.cjw.dto.MovieOrderDto;
import com.cjw.movieGuest.mapper.GuestOrderMapper;
import com.cjw.movieGuest.mapper.MovieMapper;
import com.cjw.movieGuest.model.GuestOrder;
import com.cjw.movieGuest.model.Movie;
import com.cjw.movieGuest.service.OrderService;
import com.cjw.movieGuest.service.TestService;
import com.cjw.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestService testService;
    @Autowired
    private GuestOrderMapper guestOrderMapper;

    @Transactional
    @Override
    public String buy(Integer movieId, Integer number) {
        MovieOrderDto movieOrderDto = new MovieOrderDto();
        movieOrderDto.setMovieId(movieId);
        movieOrderDto.setNumber(number);
        movieOrderDto.setState(0);
        long l = System.currentTimeMillis();
        movieOrderDto.setOrderNumber(l);
        Movie movie = movieMapper.selectById(movieId);
        movieOrderDto.setPrice(movie.getMoviePrice()*number);

        GuestOrder guestOrder = new GuestOrder();
        guestOrder.setFkMovieId(movieId);
        guestOrder.setNumber(number);
        guestOrder.setOrderNumber(l);
        guestOrder.setPrice(movie.getMoviePrice()*number);
        int insert = guestOrderMapper.insert(guestOrder);

        if (insert>0){
            return testService.buy(movieOrderDto);
        }else{
            return StringUtil.BUY_NO;
        }

    }

    @Override
    public Integer updateState(long orderNumber) {
        GuestOrder guestOrder = new GuestOrder();
        guestOrder.setState(1);
        guestOrder.setOrderNumber(orderNumber);
        int i = guestOrderMapper.updateByOrderNumber(orderNumber);
        return i;
    }


}
