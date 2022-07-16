package com.qf.ability.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;


import java.util.List;

/**
 * 商品信息es对应的实体
 * ES  ->索引 ——》分片-> 副本
 * es   中索引库是由n个分片组成  shards =1   一个分片   replicas   副本
 * 一个实体类对应一个索引库
 * @author qiu16
 */
@Data
@Document(indexName="", shards=1, replicas=0)
public class GoodsSearchInfo {
    /**
     * @Id  标识主键
     */
    @Id
    private Long id;
    /**
     * 通过分类id搜索
     */
    @Field(type= FieldType.Long)
    private Long fid;
    /**
     * 字符串分为keyword 和text
     * keyword:不分词
     * text:分词，不可参与聚合
     */
    @MultiField(
            mainField = @Field(type = FieldType.Text, analyzer = "ik_max_word"),
            otherFields = {
                    @InnerField(suffix = "pinyin",type=FieldType.Text,analyzer = "pinyin")
            }
    )
    private  String title;

    /**
     * 价格,  es价格精度很多功能不能实现
     * 精度更高,转换整数存在es
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 商品基本信息描述
     * es创建字段为了搜索
     */
    /**
     * 返利比例  不参与搜索仅是展示
     */
    @Field(type = FieldType.Double,index = false)
    private Double bili;
    /**
     * 状态上架,下架
     * 自营商品展示
     * Es存储字段基本市图片上看到的信息
     */
    /**
     * 商品图片展示,
     */
    @Field(type = FieldType.Keyword,index = false)
    private String image;
    /**
     * 商品规格 存法
     *
     * 5-电冰箱
     * 规格名称---规则值   开门方式 ----双开门
     * 规格名称带id
     * 直接存规格   vvvvvvvvvvbn     */
    /**
     * 一个商品管理多个规格
     */
    private List<GoodsGuigeSearch> guiges;
}
