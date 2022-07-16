package com.qf.data.system.dto;

import com.ken.mybatis.annotation.ToMore;
import com.qf.data.system.entity.Employee;
import com.qf.data.system.entity.Power;
import com.qf.data.system.entity.Role;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/** 用户 - 角色 - 权限 DTO对象
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@Accessors(chain = true)
public class EmployeePowerDto extends Employee implements Serializable {

    //拥有的角色列表
    @ToMore(type = Role.class)
    private List<Role> roles;

    //拥有的权限列表
    @ToMore(type = Power.class)
    private List<Power> powers;
}
