package com.qf.commons.sentinel.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SentinelNacosConfig.class)
public class SentinelAutoConfiguration {
    @Bean
    public ApplicationRunning getRunning(){
        return new ApplicationRunning();
    }
}
