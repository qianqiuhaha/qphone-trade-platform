package com.qf.business.user.servie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.user.mapper.UserMapper;
import com.qf.business.user.servie.UserService;
import com.qf.data.user.entity.User;

/**
 * @author qiu16
 */
public class UserServieImpl extends ServiceImpl<UserMapper,User> implements UserService  {
    @Override
    public User queryOpenId(String openId) {
        User user = super.query().eq("open_id", openId).one();
        return user;
    }
}
