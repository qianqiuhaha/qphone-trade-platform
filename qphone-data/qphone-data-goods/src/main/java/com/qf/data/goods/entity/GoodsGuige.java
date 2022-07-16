package com.qf.data.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.awt.*;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class GoodsGuige implements Serializable {
    //规格id
    @TableId(type = IdType.AUTO)
    private Long id;
    //规格名称
    private String guigeName;
}
