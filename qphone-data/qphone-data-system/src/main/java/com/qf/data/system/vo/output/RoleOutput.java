package com.qf.data.system.vo.output;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class RoleOutput implements Serializable {
    //主键
    private Long id;
    //部门名称
    private String depName;
    //角色名称
    private String roleName;
    //角色标识
    private String roleTag;
    //创建时间
    private Date createTime;
}
