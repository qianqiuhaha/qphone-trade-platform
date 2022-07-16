package com.qf.business.system.controller;

import com.qf.business.system.service.PowerService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.base.utils.QfBeanUtils;
import com.qf.data.system.dto.PowerDto;
import com.qf.data.system.entity.Power;
import com.qf.data.system.vo.input.PowerInput;
import com.qf.data.system.vo.output.PowerOutput;
import com.qf.data.system.vo.output.PowerSimpleOutput;
import com.qf.data.system.vo.output.PowerTreeNodeOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;


    /**
     * 部门权限查询
     * @return
     */
    @RequestMapping("/list")
    public R list(){
        List<PowerDto> powerDtos = powerService.queryList();
        List<PowerOutput> powerOutputs = QfBeanUtils.listCopy(powerDtos, PowerOutput.class);
        return Rs.create(powerDtos);
    }
    /**
     * 部门新增的时候进行权限查询
     */
    @RequestMapping("/listByInsert")
    public R listByInsert(){

        List<PowerDto> powerDtos = powerService.queryList();
        List<PowerSimpleOutput> powerSimpleOutputs= QfBeanUtils.listCopy(powerDtos, PowerSimpleOutput.class);
        return Rs.create(powerSimpleOutputs);
    }

    /**
     * 新增权限
     * @param powerInput
     * @return
     */
    @RequestMapping("/insert")
    public R insert(@Validated PowerInput powerInput){
        //进行权限的转换
        Power power = QfBeanUtils.beanCopy(powerInput, Power.class);
        powerService.save(power);
        return Rs.create("success");
    }

    /**
     *设置权限,进行权限树的查询
     */
    @RequestMapping("/listByTreeNode")
    public R listByTree(){
        System.out.println("触发权限树的查询");
        List<Power>  powers  = powerService.query().orderByAsc("pid").list();
        //    存放顶级的父级权限
        List<PowerTreeNodeOutput> rootTreeNode = new ArrayList<>();

        //存放权限数
        Map<Long,PowerTreeNodeOutput> treeNodeOutputMap=new HashMap<>();

        for (Power power :powers){
            //将权限转换成为权限树对象
            PowerTreeNodeOutput powerTreeNodeOutput=new PowerTreeNodeOutput()
                    .setId(power.getId())
                    .setLabel(power.getPowerName())
                    .setType(power.getType());
            if (power.getPid()!=null){
                //查找父节点点,并且把节点存放父节点的id
                PowerTreeNodeOutput parentTreeNode = treeNodeOutputMap.get(power.getPid());
                parentTreeNode.addChildren(powerTreeNodeOutput);
            }else {
                rootTreeNode.add(powerTreeNodeOutput);
            }
            treeNodeOutputMap.put(powerTreeNodeOutput.getId(),powerTreeNodeOutput);

        }
        return Rs.create(rootTreeNode);
    }

}
/**
 *
 * 进行权限结合的判断
 *
 */