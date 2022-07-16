package com.qf.commons.core.utils;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author qiu16
 */
public class AppliationUtils implements ApplicationContextAware {
    public static ApplicationContext context;

    /**
     * 从容器里面获取对象
     */
    public static <T> T getBean(Class<T> T){
        return context.getBean(T);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }
    /**
     * DU
     */
}
