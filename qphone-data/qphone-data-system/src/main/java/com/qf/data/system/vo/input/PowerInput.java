package com.qf.data.system.vo.input;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class PowerInput implements Serializable {

    //父级权限的id
    private Long pid;
    //权限名称
    @NotBlank(message = "权限名称不能为空！")
    private String powerName;
    //权限的标识
    private String powerTag;
    //权限资源
    private String powerResource;
    @Range(min = 1, max = 3, message = "权限类型不正确！")
    //权限的类型 1-一级权限 2-二级权限 3-三级权限（页面的各种按钮）
    private Integer type;
}
