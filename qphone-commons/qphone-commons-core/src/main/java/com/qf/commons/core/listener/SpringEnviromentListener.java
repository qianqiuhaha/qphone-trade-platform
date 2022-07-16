package com.qf.commons.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * springBoot事件的监听
 * @author qiu16
 */
@Slf4j
public class SpringEnviromentListener implements GenericApplicationListener {
    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return eventType.getRawClass() == ApplicationEnvironmentPreparedEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        log.info("{}  springboot初始化",applicationEvent);
        //强制事件类型住那混
        ApplicationEnvironmentPreparedEvent environmentPreparedEvent=(ApplicationEnvironmentPreparedEvent)applicationEvent;
        //获得SpringBoot初始化成功的环境对象
        ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        log.info("微服务的名称{} ",appName);
        MDC.put("logName",appName);
        MDC.put("logPath",appName);
    }
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 19;
    }
}
