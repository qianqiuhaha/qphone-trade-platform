package com.qf.data.system.vo.output;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限树 节点的输出对象
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
@Data
@Accessors(chain = true)
public class PowerTreeNodeOutput implements Serializable {
    private Long id;
    private String label;
    private Integer type;
    private List<PowerTreeNodeOutput> children = new ArrayList<>();

    public void addChildren(PowerTreeNodeOutput powerTreeNodeOutput){
        this.children.add(powerTreeNodeOutput);
    }
}
