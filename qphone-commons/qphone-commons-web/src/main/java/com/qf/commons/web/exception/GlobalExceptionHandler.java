package com.qf.commons.web.exception;
import com.qf.commons.standar.exeption.IExptionHandler;
import com.qf.data.base.r.Codes;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author qiu16
 */
@RestControllerAdvice
@Slf4j
public class   GlobalExceptionHandler  {

    @Autowired(required = false)
    private List<IExptionHandler> exceptionHandlers;





    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        System.out.println("统一一场处理");
//        如果统一异常处接受到反沪
          if (exceptionHandlers!=null){
              for (IExptionHandler exptionHandler:exceptionHandlers){
                    //判断是否未需要匹配的异常
                  if (exptionHandler.isSupport(e)){
                      R r = exptionHandler.exceptionHandler(e);
                      if (r!=null){
                          return r;
                      }
                  }
              }
          }
//          触发全局异常

        return Rs.createFail(Codes.FAIL);
    }
    //统一异常处理
}
