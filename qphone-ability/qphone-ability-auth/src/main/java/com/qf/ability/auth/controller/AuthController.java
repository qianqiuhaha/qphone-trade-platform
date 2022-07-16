package com.qf.ability.auth.controller;


import com.qf.ability.auth.service.AuthService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiu16
 */
@RestController
@RequestMapping("auth/wx")
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * 微信小程序登录通过访问权限服务去访问用户服务
     */
    @RequestMapping("/login")
    public R wxLogin(String code , String nickname,String header){
        System.out.println("认证服务器获取登录凭证"+code);
        return Rs.create(nickname);
    }


}
