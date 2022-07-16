package com.qf.data.system.vo.input;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 职工搜索的入参对象
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
public class EmpSearchInput implements Serializable {

    private String keyword;
    private Long depId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
