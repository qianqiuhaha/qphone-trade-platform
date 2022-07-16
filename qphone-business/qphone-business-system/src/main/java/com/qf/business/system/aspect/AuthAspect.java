package com.qf.business.system.aspect;

import com.qf.business.system.power.Auth;
import com.qf.commons.web.utils.HttpUtils;
import com.qf.data.system.entity.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author qiu16
 */
@Aspect
public class AuthAspect {
    /**
     * 对于所有Controller方法进行权限拦截
     * @return
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RestController)")
    public Object authHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取目标方法的注解
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Auth auth = method.getAnnotation(Auth.class);

        //获取session 用户登录凭证
        HttpServletRequest request = HttpUtils.getRequest();
        HttpSession session = request.getSession();
        //获取登陆员工的信息
        Employee login_emp = (Employee) session.getAttribute("login_emp");
        /**
         * 1.访问接口的注解   而且mustLogin=false -> 放行
         * 2.已经登陆 并且访问接口有注解 mustLogin=true ->放行
         * 3.已经登陆了但是访问的权限没有注解 进行权限的判定 mustLogin=true---》放行
         * 4.默认返回登录所需要的错误消息
         */
        //接口拥有false注解进行
        //给拥有接口为false的注解进行放行
        if (auth!=null && auth.mustLogin()!=false){
            return proceedingJoinPoint.proceed();
        }

        //已经登陆了 访问权限拥有注解   进行权限判定
        if(auth!=null && login_emp!=null && auth.mustLogin()){
            return proceedingJoinPoint.proceed();
        }

        //2.给已经登录但是没有注解的进行放行
        if (login_emp!=null){
            if (login_emp.getId()==1){
                    return proceedingJoinPoint.proceed();
            }
            //根据链接进行用户权限判断
            String requestURI = request.getRequestURI();
            System.out.println("需要访问的资源"+requestURI);

        }
        return null;
    }
}
