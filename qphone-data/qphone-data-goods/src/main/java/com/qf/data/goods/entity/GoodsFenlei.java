package com.qf.data.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商品分类
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class GoodsFenlei {
    //分类的主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //父级分类的id
    private Long pid;
    //分类名称
    private String fenleiName;
}
