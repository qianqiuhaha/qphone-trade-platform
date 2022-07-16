package com.qf.data.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ken.mybatis.annotation.IdAlias;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * (Power)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:16:52
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class Power extends BaseEntity implements Serializable {
    //主键
    @TableId(type = IdType.AUTO)
    @IdAlias("powerid")
    private Long id;
    //父级权限的id
    private Long pid;
    //权限名称
    @TableField("power_name")
    private String powerName;
    //权限的标识
    @TableField("power_tag")
    private String powerTag;
    //权限资源
    @TableField("power_resource")
    private String powerResource;
    //权限的类型 1-一级权限 2-二级权限 3-三级权限（页面的各种按钮）
    private Integer type;
}


