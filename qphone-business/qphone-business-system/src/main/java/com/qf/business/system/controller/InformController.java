package com.qf.business.system.controller;

import com.qf.business.system.service.InformMessageService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.system.entity.InformMessage;
import com.qf.data.system.vo.input.InformMessageInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiu16
 */
@RestController
@RequestMapping("/info")
public class InformController {
    @Autowired
    private InformMessageService informMessageService;

    /**
     * 公告信息的发布
     * @param informMessageInput
     * @return
     */
    @RequestMapping("/save")
    public R recevieMessage(InformMessage informMessageInput){
        informMessageService.save(informMessageInput);
        return Rs.create("succ");
    }

    /**
     *公告消息的编辑
     * @return
     */
    @RequestMapping("/update")
    public R updateNews(InformMessage informMessage){
        informMessageService.updateById(informMessage);
        return Rs.create("succ");
    }


    /**
     *
     */
    @RequestMapping("/delete")
    public R deleteMessage(Integer id){
        informMessageService.removeById(id);
        return Rs.create("succc");
    }

    /**
     * 公告信息的查询
     * @return
     */
    @RequestMapping("/list")
    public R listMessage(){
        List<InformMessage> list = informMessageService.list();
        return Rs.create(list);
    }


    /**
     * 通过id查询公告的信
     */
    @RequestMapping("queryById")
    public R queryMessageById(InformMessage informMessage){
        InformMessage informMessage1 = informMessageService.query().eq("id", informMessage.getId()).one();
        return Rs.create(informMessage1);
    }
}
