package com.qf.business.goods.controller;

import com.qf.business.goods.service.GoodsFenleiService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.base.utils.QfBeanUtils;
import com.qf.data.goods.entity.GoodsFenlei;
import com.qf.data.goods.vo.input.FenLeiInput;
import com.qf.data.goods.vo.output.FenleiNode;
import jdk.internal.org.objectweb.asm.tree.FieldNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu16
 */
@RestController
@Slf4j
@RequestMapping("/fenlei")
public class FenleiController {
    @Autowired
    GoodsFenleiService goodsFenleiService;
    /**
     * 新增商品规格分类
     */
    @RequestMapping("/request")
    public R insert(FenLeiInput fenLeiInput){
        log.info("商品输入新增前查询----{}",fenLeiInput);
        GoodsFenlei goodsFenlei = QfBeanUtils.beanCopy(fenLeiInput, GoodsFenlei.class);
        goodsFenleiService.save(goodsFenlei);
        return Rs.create("succ");
    }

    /**
     * 商品规格权限树的查询
     * @return
     */
    @RequestMapping("/list")
    public R list(){

        //转换
        List<FenleiNode> nodes = new ArrayList<>();

        //准备一个map
        Map<Long, FenleiNode> nodeMap = new HashMap<>();
        List<GoodsFenlei> fenleis = goodsFenleiService.list();
        for (GoodsFenlei fenlei : fenleis) {
            FenleiNode node = fenleiNode2(fenlei);
            nodeMap.put(node.getId(), node);
            if (fenlei.getPid() == null) {
                //顶级分类
                nodes.add(node);
            } else {
                //非顶级分类
                //从map中获取上一级的Node节点
                FenleiNode parentNode = nodeMap.get(fenlei.getPid());
                parentNode.addNode(node);
            }
        }
        return Rs.create(nodes);
//        //获取父级的分类
//        List<FenleiNode> fenleiNodes = new ArrayList<>();
//        //准备一个map集合添加分类
//        Map<Long, FenleiNode> map = new HashMap<>();
//        //查询当前集合下面的所有分类
//        List<GoodsFenlei> goodsFenleis = goodsFenleiService.query().list();
//        for (GoodsFenlei goodsFenlei:goodsFenleis){
//            FenleiNode fenleiNode = fenleiNode2(goodsFenlei);
//            map.put(fenleiNode.getId(),fenleiNode);
//            if (goodsFenlei.getPid()==null){
//                fenleiNodes.add(fenleiNode);
//            }else{
//                //不是顶级的分类从Map集合中获取分类的id
//                FenleiNode parentNode = map.get(fenleiNode.getId());
//                parentNode.addNode(fenleiNode);
//            }
//        }
//        log.info("{}商品规格分类查询",fenleiNodes);
//        return Rs.create(fenleiNodes);
    }
    /**
     * 分类与Nodes节点对象的转换
     */
    private static FenleiNode fenleiNode2(GoodsFenlei goodsFenlei){
        /**
         * 将goods分类转换未分类Node
         */
        FenleiNode fenleiNode = new FenleiNode();
        fenleiNode.setFenleiName(goodsFenlei.getFenleiName());
        fenleiNode.setId(goodsFenlei.getId());


        return fenleiNode;
    }
};
