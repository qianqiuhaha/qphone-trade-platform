package com.qf.business.system.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.qf.business.system.service.RolePowerTableService;
import com.qf.business.system.service.RoleServie;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.base.utils.QfBeanUtils;
import com.qf.data.system.dto.RoleDto;
import com.qf.data.system.entity.Role;
import com.qf.data.system.entity.RolePowerTable;
import com.qf.data.system.vo.input.RoleInput;
import com.qf.data.system.vo.output.RoleOutput;
import io.netty.util.ResourceLeakDetector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Autowired
    private RoleServie roleServie;

    @Autowired
    private RolePowerTableService rolePowerTableService;
    /**
     * 角色查询
     * @return
     */
    @RequestMapping("/list")
    public R list(){
        List<RoleDto> roleDtos = roleServie.queryList();
        System.out.println(roleDtos);
        List<RoleOutput> roleOutputs = QfBeanUtils.listCopy(roleDtos, RoleOutput.class);
        return Rs.create(roleOutputs);
    }

    /**
     * 新增权限
     */
    @RequestMapping("/insert")
    public R insert(RoleInput roleInput){
        Role role = QfBeanUtils.beanCopy(roleInput, Role.class);
        //新增权限
        roleServie.save(role);
        return  Rs.create("succ");
    }

    /**
     * 权限列表，树状结构
     * @return
     */
    @RequestMapping("/listByTree")
    public R listByTree(){
        return null;
    }


    /**
     * 根据角色的Id查询拥有的权限
     * @return
     */
    @RequestMapping("/rid")
    public R listById(String rid){
        List<RolePowerTable> rolePowerTables = rolePowerTableService.queryById(rid);
        List<Long> pids = rolePowerTables.stream().map(rolePowerTable -> rolePowerTable.getPid()).collect(
                Collectors.toList()
        );
        return Rs.create(pids);
    }

    /**
     * 根据用户id修改用户的权限
     * @param rid
     * @param pidsStr
     * @return
     */
    public R updatePowersByRid(Long rid,String pidsStr){
        log.info("根据角色id修改用户的权限{} - {}",rid,pidsStr);
        List<Long> pidStrs = JSON.parseArray(pidsStr, Long.class);
        //根据用户id机型权限的插入
        int i = roleServie.updatePowerByRid(rid, pidStrs);
        return Rs.create("success");
    }
}
