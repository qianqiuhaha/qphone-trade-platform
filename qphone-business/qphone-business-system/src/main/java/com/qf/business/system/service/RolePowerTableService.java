package com.qf.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.business.system.mapper.RolePowerTableMapper;
import com.qf.data.system.entity.RolePowerTable;

import java.util.List;

public interface RolePowerTableService extends IService<RolePowerTable> {
    public List<RolePowerTable> queryById(String rid);
 }
