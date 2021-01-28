package com.cjw.es;

import com.cjw.es.mapper.SourceCodeMapper;
import com.cjw.es.model.SourceCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.cjw.es.ESMain.class)
public class NewsT {

    @Autowired
    private SourceCodeMapper newsMapper;

    @Test
    public void save(){
        SourceCode sourceCode = new SourceCode();
        sourceCode.setId("1");
        sourceCode.setCode("在中土世界与甘道夫并肩；\n" +
                "　　在权力的游戏世界与龙妈同行；\n" +
                "　　在猎魔人世界与希里共舞...\n" +
                "　　这是一个行走在无限瑰丽奇幻世界的故事。\n" +
                "　　暂定世界：霍比特人，指环王，权力的游戏，猎魔人…\n" +
                "当前进度：霍比特人…");
        newsMapper.save(sourceCode);
    }

    @Test
    public void find(){
        List<SourceCode> list = newsMapper.findByCodeContains("霍比特人");
        System.out.println(list.size());
    }
}
