package com.qf.commons.web.aop;

import com.qf.commons.web.utils.HttpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiu16
 */
@Aspect
public class AuthInfoAspect {
    public Object authAround(ProceedingJoinPoint proceedingJoinPoint){
        HttpServletRequest request = HttpUtils.getRequest();
        String uidStr = request.getHeader("uid");
        return null;
    }
}
