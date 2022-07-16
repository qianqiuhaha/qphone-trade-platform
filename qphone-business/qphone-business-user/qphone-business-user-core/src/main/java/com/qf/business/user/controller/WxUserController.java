package com.qf.business.user.controller;

import com.qf.business.user.servie.UserService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.base.utils.QfBeanUtils;
import com.qf.data.user.entity.User;
import com.qf.data.user.vo.input.WxUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qiu16
 */
@RestController
@RequestMapping("/user/wx")
public class WxUserController {

    @Autowired
    UserService userService;

    @RequestMapping("query")
    public R wxUserQuery(@RequestBody @Valid WxUserInput wxUserInput){
        //用户查询接口编写
        User user = QfBeanUtils.beanCopy(wxUserInput, User.class);
        //进行用户信息的查询
        User userOne = userService.queryOpenId(user.getOpenId());
        //数据库里面没有用户信息将用户信息保存到数据库
        if (userOne==null) {
            userService.save(user);
            return Rs.create(user);
        }
        //数据库有用户信息直接将用户信息保存在userService里面
        return Rs.create(userOne);
    }
}
