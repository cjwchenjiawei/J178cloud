package com.cjw.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private  String username;
    private  String password;
    private  Integer power;
}
