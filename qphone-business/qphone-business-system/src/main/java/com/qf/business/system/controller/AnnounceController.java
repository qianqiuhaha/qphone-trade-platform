package com.qf.business.system.controller;

import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiu16
 */
@RequestMapping("/announce")
@RestController
@Slf4j
public class AnnounceController {
    /**
     * 像前端发送数据
     * @return
     */
    @RequestMapping("/send")
    public R sendMessage(){
        String Message="公告:618专属限免活动";
        System.out.println(Message);
//        页面进行数据的加载
        return Rs.create(Message);
    }
}
