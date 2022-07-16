package com.qf.commons.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author qiu16
 */
public class MySelfMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime",new Date());
        metaObject.setValue("endTime",new Date());
        metaObject.setValue("status",0);
        metaObject.setValue("deFlag",0);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime",new Date());
    }
}
