package com.cjw.redis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjw.redis.mapper.RouteMapper;
import com.cjw.redis.model.Route;
import com.cjw.redis.service.RouteService;
@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements RouteService{

}
