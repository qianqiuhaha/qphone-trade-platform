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
public class PowerSimpleOutput implements Serializable {

    private Long id;
    private String powerName;
    private Integer type;
}
