package com.qf.ability.gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author qiu16
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
    /**
     * 配置Cors过滤器 解决跨域问题
     * @return
     */
    @Bean
    public CorsWebFilter getCorsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod("*");//所有请求类型跨域 GET POST
        corsConfiguration.addAllowedHeader("*");//允许所有请求头部类型跨域
        corsConfiguration.addAllowedOrigin("*");//允许所有主机地址跨域
        corsConfiguration.setAllowCredentials(true);//允许cookie跨域

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }
}
