package com.cjw.sys.service;

public interface UserService {

    /**
     * 获取用户信息
     * @param tag 1,2,3
     * @return
     */
    public String userInfo(Integer tag);

    String scoreList();
}
