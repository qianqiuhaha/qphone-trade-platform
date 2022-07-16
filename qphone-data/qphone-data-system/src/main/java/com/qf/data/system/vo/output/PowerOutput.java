package com.qf.data.system.vo.output;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@Accessors(chain = true)
public class PowerOutput implements Serializable {
    //主键
    private Long id;
    //父权限的名称
    private String parentName;
    //权限名称
    private String powerName;
    //权限的标识
    private String powerTag;
    //权限资源
    private String powerResource;
    //权限的类型 1-一级权限 2-二级权限 3-三级权限（页面的各种按钮）
    private Integer type;
}
