package com.qf.data.system.vo.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class RoleInput implements Serializable {
    //部门id
    @NotNull(message = "部门不能为空")
    private Long depId;
    //角色名称
    @NotNull(message = "角色名称不能为空")
    private String roleName;
    //角色标识
    @NotNull(message = "角色标识不能为空")
    private String roleTag;
}
