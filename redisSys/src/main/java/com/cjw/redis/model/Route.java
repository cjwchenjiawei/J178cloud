package com.cjw.redis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "t_route")
public class Route implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "fk_user_id")
    private Integer fkUserId;

    @TableField(value = "address")
    private String address;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_FK_USER_ID = "fk_user_id";

    public static final String COL_ADDRESS = "address";
}