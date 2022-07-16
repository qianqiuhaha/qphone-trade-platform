package com.qf.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.data.system.dto.RoleDto;
import com.qf.data.system.entity.Role;

import java.util.List;

public interface RoleServie extends IService<Role> {

    List<RoleDto> queryList();

    /**
     * 根据用户的id进行权限的修改
     */
    int updatePowerByRid(Long rid,List<Long> pids);
}
