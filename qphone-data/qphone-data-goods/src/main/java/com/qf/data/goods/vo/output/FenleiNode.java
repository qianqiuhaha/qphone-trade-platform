package com.qf.data.goods.vo.output;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class FenleiNode {
    //树状结构的名称
    private Long id;
    private String fenleiName;
    private List<FenleiNode> children = new ArrayList<>();

    //添加子节点
    public void addNode(FenleiNode fenleiNode){
        this.children.add(fenleiNode);
    }
}
