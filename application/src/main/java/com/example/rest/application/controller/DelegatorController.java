package com.example.rest.application.controller;

import com.example.rest.application.common.rest.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DelegatorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @GetMapping("/delegate/demo")
    public String getDemoDelegate() {
        // 화면에 모니터링 로그 남기기
        log.info(restTemplateUtil.createHttpInfo());
        try {
            return this.restTemplate.getForObject("http://localhost:8080/demo", String.class);
        }catch(Exception e) {
            // 화면에 모니터링 로그 남기기
            log.error(restTemplateUtil.createHttpInfo());
            return e.getMessage();
        }
    }

}