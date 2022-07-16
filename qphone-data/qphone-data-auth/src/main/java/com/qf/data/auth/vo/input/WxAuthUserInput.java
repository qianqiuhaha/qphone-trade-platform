package com.qf.data.auth.vo.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author qiu16
 */
@Data
public class WxAuthUserInput {
    @NotBlank(message = "用户的登陆凭证不能为空")
    private String code;
    private String header;
    private String nickname;
}
