package com.qf.commons.web.config;

import com.qf.commons.web.aspect.LogAdviceAspect;
import com.qf.commons.web.exception.GlobalExceptionHandler;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.jws.soap.SOAPBinding;

/**
 * @author qiu16
 */
@Configuration
@ComponentScan("com.qf.commons.web.exception.handler")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.qf.feign")
public class WebAutoConfiguration {
    @Bean
    public GlobalExceptionHandler getGloablExceptionHandler(){
        System.out.println("同意一场处理装配成功");
        return new GlobalExceptionHandler();
    }
    /**
     * 日志环绕增强
     */
    @Bean
    public LogAdviceAspect getLogAdviceAspect(){
        return new LogAdviceAspect();
    }
}
