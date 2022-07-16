package com.qf.data.system.entity;

import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * (EmpRoleTable)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:15:54
 */
@Data
@Accessors(chain = true)
public class EmpRoleTable extends BaseEntity implements Serializable {
    //职工的id
    private Long eid;
    //角色id
    private Long rid;
}


