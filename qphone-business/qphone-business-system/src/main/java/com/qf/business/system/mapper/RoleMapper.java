package com.qf.business.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.data.system.dto.RoleDto;
import com.qf.data.system.entity.Role;

import java.util.List;

/**
 * @author qiu16
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询自定义的sql语句
     */
    public List<RoleDto> queryList();

}
