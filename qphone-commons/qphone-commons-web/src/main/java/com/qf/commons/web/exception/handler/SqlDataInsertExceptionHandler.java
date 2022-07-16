package com.qf.commons.web.exception.handler;

import com.qf.commons.standar.exeption.IExptionHandler;
import com.qf.data.base.r.Codes;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

/**
 * @author qiu16
 */
@Component
public class SqlDataInsertExceptionHandler  implements IExptionHandler {
    @Override
    public boolean isSupport(Exception e) {
        System.out.println("数据库异常");
        //同意一场处理捕获
        return e.getClass() == DuplicateKeyException.class;
    }

    @Override
    public R exceptionHandler(Exception e) {
        System.out.println("同一异常处理结果返回");
        return Rs.createFail(Codes.DATA_REPE);
    }
}
