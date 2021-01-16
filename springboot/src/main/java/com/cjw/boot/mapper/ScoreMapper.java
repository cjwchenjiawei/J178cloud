package com.cjw.boot.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjw.boot.model.Score;

public interface ScoreMapper extends BaseMapper<Score> {
    List<Score> findFirst5();


}