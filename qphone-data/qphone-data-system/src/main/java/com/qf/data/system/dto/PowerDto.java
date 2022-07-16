package com.qf.data.system.dto;

import com.qf.data.system.entity.Power;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * public protected default private
 *
 *
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class PowerDto extends Power implements Serializable {

    //父权限的名称
    private String parentName;
}
