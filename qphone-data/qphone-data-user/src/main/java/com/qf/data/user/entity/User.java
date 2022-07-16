package com.qf.data.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-07-04 19:08:07
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {
    /**
     * 用户id
     **/
    private Long id;

    /**
     * 微信的开放id
     **/
    private String openId;

    /**
     * 微信用户的数据加密密钥
     **/
    private String sessionKey;

    /**
     * 微信头像
     **/
    private String header;

    /**
     * 用户昵称
     **/
    private String nickName;

    
}


