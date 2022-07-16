package com.qf.business.student.controller;


import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author qiu16
 */
@RestController
@RequestMapping("/stu")
@Slf4j
public class StuController {
    @Autowired
    private Client client;
    @RequestMapping("/list")
    public R list(){
        log.info("调用当前feign的核心接口{}" +1);
        return Rs.create("succ");
    }
}
