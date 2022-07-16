package com.qf.data.system.entity;

import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * (RolePowerTable)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:17:29
 */
@Data
@Accessors(chain = true)
public class RolePowerTable extends BaseEntity implements Serializable {
    //角色id
    private Long rid;
    //权限id
    private Long pid;
}


