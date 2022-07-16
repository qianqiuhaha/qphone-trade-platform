package com.qf.data.system.vo.input;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qiu16
 * 进行消息的推送
 */
@Data
@Accessors(chain = true)
public class InformMessageInput {
    //文章的标题信息
    private String message;
    //文章的内容
    private String content;

}
