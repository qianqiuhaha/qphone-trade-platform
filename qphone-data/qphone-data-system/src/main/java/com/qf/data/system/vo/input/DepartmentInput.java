package com.qf.data.system.vo.input;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 部门表(Department)表实体类
 *
 * @author makejava
 * @since 2022-05-26 16:14:47
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class DepartmentInput implements Serializable {

    //部门名称
    @NotBlank(message = "部门名称不能为空！")
    private String depName;
}


