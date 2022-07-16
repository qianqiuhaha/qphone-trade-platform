package com.qf.data.system.vo.output;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@Accessors(chain = true)
public class  DepListOutput implements Serializable {
    //主键
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //部门名称
    private String depName;
    //部门人数
    private Integer depNum;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //状态
    private Integer status;
}
