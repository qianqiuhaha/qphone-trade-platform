package com.qf.business.system.power;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    /**
     * 是否必须登录
     * @return
     */
    boolean mustLogin() default true;

    String[] role() default "";

}
