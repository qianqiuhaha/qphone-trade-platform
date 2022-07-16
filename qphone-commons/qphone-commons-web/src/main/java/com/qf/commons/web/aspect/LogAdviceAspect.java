package com.qf.commons.web.aspect;

import com.qf.commons.web.utils.HttpUtils;
import net.sf.jsqlparser.statement.select.Join;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志的切面增强
 * @author qiu16
 */
public class LogAdviceAspect {
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取客户端的Id
        HttpServletRequest request = HttpUtils.getRequest();
        //获取客户端的地址
        String remoteHost = HttpUtils.getRemoteHost(request);
        //使用广播机制把ip放入日志当中
        MDC.put("id",remoteHost);
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }
}
