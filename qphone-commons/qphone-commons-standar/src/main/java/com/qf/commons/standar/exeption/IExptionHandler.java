package com.qf.commons.standar.exeption;

import com.qf.data.base.r.R;

import java.lang.ref.Reference;

/**
 * @author qiu16
 */
public interface IExptionHandler {
    //判断是否为需要护理的异常类型
    boolean isSupport(Exception e);

    //实际处理异常类型的方法
    //如果该方法的返回类型未空的时候,则交给全局异常捕获返回结果
    R exceptionHandler(Exception e);
}
