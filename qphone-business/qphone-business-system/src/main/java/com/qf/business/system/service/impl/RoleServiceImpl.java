package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qf.business.system.mapper.RoleMapper;

import com.qf.business.system.mapper.RolePowerTableMapper;
import com.qf.business.system.service.RolePowerTableService;
import com.qf.business.system.service.RoleServie;
import com.qf.data.system.dto.RoleDto;
import com.qf.data.system.entity.Role;
import com.qf.data.system.entity.RolePowerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleServie {
    @Autowired
    public RoleMapper roleMapper;

    @Autowired
    private RolePowerTableService rolePowerTableService;
    
    @Autowired
    public RolePowerTableMapper rolePowerTableMapper;

    @Override
    public List<RoleDto> queryList() {
       return roleMapper.queryList();
    }

    @Override
    @Transactional
    public int updatePowerByRid(Long rid, List<Long> pids) {
        /**
         * 删除用户权限表的所有权限
         */
        rolePowerTableService.removeById(rid);

        RolePowerTable rolePowerTable = new RolePowerTable();
        List<RolePowerTable> list=new ArrayList<RolePowerTable>();
        
        /**
         * 机
         */
        for (Long pid:pids){
            rolePowerTable.setRid(rid).setPid(pid);
            list.add(rolePowerTable);
        }
        /**
         * 用户数据批量插入
         */
        final int i = rolePowerTableMapper.insertRolePowerTableMapppers(list);
        return i;
    }
    /**
     *
     */

}
