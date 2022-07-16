package com.qf.data.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 部门表(Department)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:14:47
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class Department extends BaseEntity implements Serializable {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //部门名称
    private String depName;
    //部门人数
    private Integer depNum;
}


