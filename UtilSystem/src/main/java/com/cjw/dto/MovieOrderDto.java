package com.cjw.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieOrderDto implements Serializable {
    private Integer id;
    private Integer movieId;
    private long orderNumber;
    private Integer number;
    private Integer price;
    private Integer state;
}
