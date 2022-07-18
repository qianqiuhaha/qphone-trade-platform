package com.qf.ability.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.log.Log;
import com.qf.ability.auth.service.AuthService;
import com.qf.business.user.feign.UserFeign;
import com.qf.data.auth.vo.input.WxAuthUserInput;
import com.qf.data.base.r.R;
import com.qf.data.user.entity.User;
import com.qf.data.user.vo.input.WxUserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiu16
 */
@Slf4j
@Service
public class  WxAuthServieImpl implements AuthService {
    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private UserFeign userFeign;
    @Override
    public void wxLogin(WxAuthUserInput wxAuthUserInput) {
        /**
         * 小程序客户端像开发者发送自己的appid
         * 密钥
         *
         * 开发者根据小程序的appid和密钥像小程序的服务端发送请求，获取通信凭证
         *
         * 小程序服务器接受开发者服务的请求进行通信凭证的匹配，请求通过发放通信凭证
         * session_key
         * open_id
         */
        /**
         *
         */
        String result = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=wx230be851070e1001&secret=&js_code="+wxAuthUserInput.getCode()+"&grant_type=authorization_code", String.class);
        log.info("[wxlogin]-微信用户登陆凭证{}",result);
        //微信登录凭证上传到用户服务,获取微信服务器上传的
        JSONObject jsonObject = JSON.parseObject(result);
        String sessionKey=jsonObject.getString("session_key");
        String openId=jsonObject.getString("openID");
        //把微信服务器返回的session_key 和openID放入wxUserInput里面
        WxUserInput wxUserInput = new WxUserInput();
        wxUserInput.setOpenId(openId);
        wxUserInput.setSessionKey(sessionKey);
        wxUserInput.setNickName(wxAuthUserInput.getNickname());
        wxUserInput.setHeader(wxAuthUserInput.getHeader());
        //调用微服务将数据存放到数据库里面
        User user = (User) userFeign.wxUserQuery(wxUserInput).result();



    }


}
