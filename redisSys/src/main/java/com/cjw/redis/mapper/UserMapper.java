package com.cjw.redis.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjw.redis.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User findOneByUsername(@Param("username")String username);




}