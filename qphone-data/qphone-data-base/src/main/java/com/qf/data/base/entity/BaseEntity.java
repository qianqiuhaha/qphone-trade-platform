package com.qf.data.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 * @author qiu16
 */
@Data
public class  BaseEntity implements Serializable {
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //状态
    @TableField(fill = FieldFill.INSERT)
    private Integer status;
    //删除标识
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
