package com.qf.business.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.data.system.dto.PowerDto;
import com.qf.data.system.entity.Power;

import java.util.List;

public interface PowerMapper extends BaseMapper<Power> {
    //自连查询,并且查询父级别权限的名称
    List<PowerDto> queryList();
}
