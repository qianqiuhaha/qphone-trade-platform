package com.qf.data.system.vo.output;

import com.qf.data.system.entity.Power;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@Accessors(chain = true)
public class EmployeeOutput implements Serializable {
    private Long id;
    //员工姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //头像
    private String header;
    //员工状态
    private Integer status;
    //权限列表
    private List<Power> powers;
}
