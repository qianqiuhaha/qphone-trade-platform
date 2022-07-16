package com.qf.business.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.qf.data.system.entity.RolePowerTable;

import java.util.List;

/**
 * @author qiu16
 */
//
public interface RolePowerTableMapper extends BaseMapper<RolePowerTable> {

    /**
     * 用户数据批量插入
     */
    int insertRolePowerTableMapppers(List<RolePowerTable> rolePowerTables);

}
