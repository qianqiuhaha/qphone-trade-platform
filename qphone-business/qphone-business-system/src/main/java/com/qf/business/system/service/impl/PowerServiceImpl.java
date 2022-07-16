package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.system.mapper.PowerMapper;
import com.qf.business.system.service.PowerService;
import com.qf.data.base.r.R;
import com.qf.data.system.dto.PowerDto;
import com.qf.data.system.entity.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author qiu16
 * (POWER)表服务的实现类
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {
        //权限查询
    @Autowired
    public PowerMapper powerMapper;


    @Override
    public List<PowerDto> queryList() {
        return powerMapper.queryList();
    }
}
