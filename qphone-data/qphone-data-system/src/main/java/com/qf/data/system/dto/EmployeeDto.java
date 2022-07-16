package com.qf.data.system.dto;

import com.qf.data.system.entity.Employee;
import lombok.Data;

import java.io.Serializable;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class EmployeeDto extends Employee implements Serializable {

    //部门名称
    private String depName;
}
