package com.qf.data.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qf.data.base.entity.BaseEntity;

import java.io.Serializable;

public class GoodsGuigeVal extends BaseEntity implements Serializable {
    //id
    @TableId(type = IdType.AUTO)
    private Long id;
    //关联的规格id
    private Long guigeId;
    //值
    private String guigeVal;
}
