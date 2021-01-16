package com.cjw.boot.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjw.boot.model.Score;
import com.cjw.boot.mapper.ScoreMapper;
import com.cjw.boot.service.ScoreService;
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService{

}
