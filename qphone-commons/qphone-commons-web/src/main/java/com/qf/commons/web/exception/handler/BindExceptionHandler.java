package com.qf.commons.web.exception.handler;

/**
 * @author qiu16
 */


import com.qf.commons.standar.exeption.IExptionHandler;
import com.qf.data.base.r.Codes;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 参数校验异常的绑定
 * @author qiu16
 */
public class BindExceptionHandler  implements IExptionHandler {
    @Override
    public boolean isSupport(Exception e) {
        return e.getClass()== BindException.class;
    }

    @Override
    public R exceptionHandler(Exception e) {
//      墙砖绑定异常
        BindException bindException=(BindException) e;
        //获取所有绑定错误
        Map<String, String> result = bindException.getAllErrors().stream().collect(Collectors.toMap(
                objectError -> objectError.getCodes()[1],
                objectError -> objectError.getDefaultMessage()
        ));
        return Rs.createFail(Codes.FARM_ERROR, result);
    }
}
