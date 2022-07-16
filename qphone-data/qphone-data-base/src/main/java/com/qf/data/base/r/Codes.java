package com.qf.data.base.r;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Codes {
    SUCC(200,"成功"),
    FAIL(500,"服务器异常"),
    NOT_FOUND(404,"资源未找到"),
    FARM_ERROR(405,"参数校验未通过"),
    LOGIN_FAIL(406,"用户名或者密码错误"),
    NOT_LOGIN(411,"用户必须登录后才能访问"),
    NO_POWER(412,"权限不足"),
    DATA_REPE(407,"数据库插入数据重复");



    private Integer code;
    private String msg;
}
