package com.qf.data.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ken.mybatis.annotation.IdAlias;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 角色表(Role)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:17:12
 */
@Data
@Accessors(chain = true)
public class Role extends BaseEntity implements Serializable {
    //主键
    @TableId(type = IdType.AUTO)
    @IdAlias("rid")
    private Long id;
    //部门id
    @TableField("dep_id")
    private Long depId;
    //角色名称
    @TableField("role_name")
    private String roleName;
    //角色标识
    @TableField("role_tag")
    private String roleTag;
}


