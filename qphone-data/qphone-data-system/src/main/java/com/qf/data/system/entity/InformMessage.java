package com.qf.data.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 公告消息推送小程序
 * @author qiu16
 */
@Data
@Accessors(chain = true)
public class InformMessage extends BaseEntity implements Serializable {
    /**
     * 给修改的消息声明一个ID标识
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * message 推送信息的标题
     */
    private String message;
    /**
     * 推送信息的内容
     */
    private String content;
}
