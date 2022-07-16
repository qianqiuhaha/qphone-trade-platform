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
public class RoleDto2 extends Role implements Serializable {

    /**
     * 指定用户是否拥有该角色
     */
    private Boolean isChecked;
}
