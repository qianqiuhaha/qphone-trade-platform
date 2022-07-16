package com.qf.data.system.vo.output;

import lombok.Data;

import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class RoleOutput2 implements Serializable {
    //主键
    private Long id;
    //角色名称
    private String roleName;
    //角色标识
    private String roleTag;
    //是否拥有
    private Boolean isChecked;
}
