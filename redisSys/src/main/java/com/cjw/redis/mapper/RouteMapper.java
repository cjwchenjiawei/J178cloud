package com.cjw.redis.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjw.redis.model.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteMapper extends BaseMapper<Route> {
    List<Route> findAllByFkUserId(@Param("fkUserId")Integer fkUserId);


}