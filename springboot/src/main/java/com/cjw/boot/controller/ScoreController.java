package com.cjw.boot.controller;

import com.cjw.boot.mapper.ScoreMapper;
import com.cjw.boot.model.Score;
import com.cjw.boot.service.ScoreService;
import com.cjw.dto.UserDto;
import com.cjw.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreMapper scoreMapper;
    @GetMapping("/score/list/{token}")
    public String list(@PathVariable("token") String token){
        List<Score>scoreList = new ArrayList<>();
        UserDto userDto = JwtUtil.verifierJwt(token);
        if (userDto.getPower()==1){
            scoreList = scoreMapper.findFirst5();
        }else{
            scoreList = scoreService.list();
        }
        return scoreList.toString();
    }
}
