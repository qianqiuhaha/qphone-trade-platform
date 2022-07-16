package com.qf.commons.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * 革新模块的自动配置类
 * @author qiu16
 */
@ComponentScan({"com.qf.business", "com.qf.data.*.vaild","com.qf.ability"})

public class CoreAutoConfiguration {
}
