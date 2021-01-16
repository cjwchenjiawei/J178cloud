package com.cjw.power.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjw.power.model.User;

public interface UserMapper extends BaseMapper<User> {
    User selectOneByUsernameAndPassword(@Param("username")String username,@Param("password")String password);






}