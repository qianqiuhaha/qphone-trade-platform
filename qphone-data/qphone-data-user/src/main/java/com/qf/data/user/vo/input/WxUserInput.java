package com.qf.data.user.vo.input;

import lombok.Data;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;



@Data
public class WxUserInput implements Serializable {
    /**
     * 微信的开放id
     **/
    @NotBlank(message = "微信的用户开放id不能为空")
    private String openId;

    /**
     * 微信用户的数据加密密钥
     **/
    @NotBlank(message = "微信用户的session_key不能为空")
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
