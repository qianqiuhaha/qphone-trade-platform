package com.qf.data.system.dto;

import com.qf.data.system.entity.Role;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@ToString(callSuper = true)
public class RoleDto extends Role implements Serializable {

    //所属部门的名称
    private String depName;
}
