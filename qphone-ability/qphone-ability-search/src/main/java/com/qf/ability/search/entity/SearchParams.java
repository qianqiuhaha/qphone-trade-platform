package com.qf.ability.search.entity;

import com.qf.ability.search.service.IGoodsSearch;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.slf4j.Log4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SearchParams {
    @Autowired
    private IGoodsSearch iGoodsSearch;
    public R searchGoods(SearchParams searchParams){
        log.info("");
        return Rs.create(null);
    }
}
