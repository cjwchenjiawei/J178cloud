package com.cjw.es.controller;

import com.cjw.es.mapper.SourceCodeMapper;
import com.cjw.es.mapper.UrlMapper;
import com.cjw.es.model.SourceCode;
import com.cjw.es.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.util.List;

@Controller
@RequestMapping("/es")
public class ESController {

    @Autowired
    private UrlMapper urlMapper;
    @Autowired
    private SourceCodeMapper sourceCodeMapper;

    @GetMapping("/save")
    @ResponseBody
    public Integer saveUrl(String url) {
        System.out.println("url = " + url);
        Url u = new Url();
        u.setUrl(url);
        return urlMapper.insert(u);
    }

    @GetMapping("/find/{keyword}")
    @ResponseBody
    public List<SourceCode> findSourceCodeByKeyword(@PathVariable("keyword") String keyword) {
        return sourceCodeMapper.findByCodeContains(keyword);
    }
}
