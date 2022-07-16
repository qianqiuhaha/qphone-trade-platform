package com.qf.data.system.vo.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class EmployeeInput implements Serializable {

    //用户名
    @NotBlank(message = "用户名不能为空！")
    private String username;
    //密码
    @NotBlank(message = "密码不能为空！")
    private String password;
    //部门id
    private Long depId=1L;
    //员工姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //头像
    private String header;
}
