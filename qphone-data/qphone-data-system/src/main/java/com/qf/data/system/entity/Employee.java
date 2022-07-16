package com.qf.data.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ken.mybatis.annotation.ToMore;
import com.qf.data.base.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


/**
 * 职工表(Employee)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:16:37
 */
@Data
@Accessors(chain = true)
public class Employee extends BaseEntity implements Serializable {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //部门id
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long depId;
    //员工姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //头像
    private String header;



}


