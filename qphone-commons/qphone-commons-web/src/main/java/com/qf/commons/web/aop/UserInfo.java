package com.qf.commons.web.aop;

/**
 * @author qiu16
 */
public class UserInfo {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();
    public static void setUid(){}
    public static void clean(){

    }

}
