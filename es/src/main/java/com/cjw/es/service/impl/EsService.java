package com.cjw.es.service.impl;

import com.cjw.es.mapper.SourceCodeMapper;
import com.cjw.es.model.SourceCode;
import com.cjw.es.model.Url;
import com.cjw.es.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class EsService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SourceCodeMapper sourceCodeMapper;
    @Autowired
    private UrlService urlService;
    @Scheduled(cron = "*/5 * * * * MON-FRI")
    public void activateService() {
        // 得到所有url
        List<Url> urlList = urlService.list();
        for (Url url : urlList) {
            SourceCode code = new SourceCode();
            String body = restTemplate.getForEntity(url.getUrl(), String.class).getBody();
            code.setId(String.valueOf(UUID.randomUUID()));
            code.setCode(body);
            code.setUrl(url.getUrl());
            System.out.println("body = " + body);
            sourceCodeMapper.save(code);
        }
    }
}
