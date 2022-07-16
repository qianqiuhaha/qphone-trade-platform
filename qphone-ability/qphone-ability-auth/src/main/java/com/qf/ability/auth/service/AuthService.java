package com.qf.ability.auth.service;

import com.qf.data.base.r.R;
import com.qf.data.user.vo.input.WxUserInput;

/**
 * @author qiu16
 */
public interface AuthService{
    //认证服务进行用户认证服务的登录判断
    public void wxLogin(WxUserInput wxUserInput);
}
