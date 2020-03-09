package com.example.rest.application.config.rest;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

// Resttemplete 설정 값 매핑
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "httpconnpool")
@Data
@ToString
public class HttpHostsConfiguration {

    private Integer maxTotal;
    private Integer defaultMaxPerRoute;
    private Integer maxPending;
    private Integer connectionRequestTimeout;
    private Integer connectionTimeout;
    private Integer socketTimeout;
    private List<HttpHostConfiguration> maxPerRoutes;

    @Data
    @ToString
    public static class HttpHostConfiguration {

        private String scheme;
        private String host;
        private Integer port;
        private Integer maxPerRoute;

    }
}
