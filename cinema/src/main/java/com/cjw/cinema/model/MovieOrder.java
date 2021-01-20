package com.cjw.cinema.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_movie_order")
public class MovieOrder implements Serializable {
    public static final String COL_FK_MOVIE = "fk_movie";
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    @TableField(value = "order_number")
    private Long orderNumber;

    @TableField(value = "fk_movie_id")
    private Integer fkMovieId;

    /**
     * 电影购买票数
     */
    @TableField(value = "`number`")
    private Integer number;

    /**
     * 订单总金额
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 0为已付款未出票，1为出票成功
     */
    @TableField(value = "`state`")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_FK_MOVIE_ID = "fk_movie_id";

    public static final String COL_NUMBER = "number";

    public static final String COL_PRICE = "price";

    public static final String COL_STATE = "state";
}