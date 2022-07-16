package com.qf.ability.search.service.impl;

import com.qf.ability.search.entity.GoodsSearchInfo;
import com.qf.ability.search.service.IGoodsSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoodsSearchServiceImpl implements IGoodsSearch {
    @Autowired
    public ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Override
    public boolean createIndex() {
        /**
         * 索引不存在创建索引
         */
        if (!isExsite()){
            log.info("索引不存在创建索引");
            IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(GoodsSearchInfo.class);
            if (indexOperations.create()){
                log.info("创建映射");
                final Document mapping = indexOperations.createMapping(GoodsSearchInfo.class);

            }
        }
        return false;
    }

    @Override
    public boolean isExsite() {
        return false;
    }
}
