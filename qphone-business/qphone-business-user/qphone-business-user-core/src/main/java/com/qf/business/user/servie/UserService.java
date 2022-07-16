package com.qf.business.user.servie;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.data.user.entity.User;

/**
 * @author qiu16
 */
public interface UserService  extends IService<User> {

    User queryOpenId(String openId);
}