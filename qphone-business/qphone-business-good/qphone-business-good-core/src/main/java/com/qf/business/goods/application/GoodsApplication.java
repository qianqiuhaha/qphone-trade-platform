package com.qf.business.goods.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author qiu16
 */

@SpringBootApplication
@ComponentScan("com.qf.business.goods")

public class GoodsApplication {
    /**
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
    @Bean
    public CorsFilter getCorsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod("*");//所有请求类型跨域 GET POST
        corsConfiguration.addAllowedHeader("*");//允许所有请求头部类型跨域
        corsConfiguration.addAllowedOrigin("*");//允许所有主机地址跨域
        corsConfiguration.setAllowCredentials(true);//允许cookie跨域

        org.springframework.web.cors.UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }
}
