package com.cjw.boot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "t_score")
public class Score implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "stuName")
    private String stuname;

    @TableField(value = "score")
    private Integer score;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_STUNAME = "stuName";

    public static final String COL_SCORE = "score";
}