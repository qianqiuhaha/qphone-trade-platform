package com.qf.ability.search.entity;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * @author qiu16
 *
 * 商品  嵌套类型没有必要打Document
 */
public class GoodsGuigeSearch {
    /**
     * 规格名称不分次
     */
    @Field(type = FieldType.Keyword)
    private String guigeName;
    @MultiField(
            mainField = @Field(type = FieldType.Keyword),
            otherFields={
                    @InnerField(suffix = "analyer",type = FieldType.Text,analyzer = "ik_max"),
                    @InnerField(suffix = "pinyin",type = FieldType.Text,analyzer = "pinyin")
    }
    )
    private String guigeVal;
}
