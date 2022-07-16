package com.qf.commons.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.qf.commons.mybatis.handler.MySelfMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author qiu16
 */
@Configuration
@MapperScan("com.qf.**.mapper")
@EnableTransactionManagement
public class MybatisAutoConfiguration {
    @Bean
    public MetaObjectHandler getMetaObjectHandler(){
        return new MySelfMetaObjectHandler();
    }
}
