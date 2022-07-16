package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.system.mapper.RolePowerTableMapper;
import com.qf.business.system.service.RolePowerTableService;
import com.qf.data.system.entity.RolePowerTable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiu16
 */
@Service
public class RolePowerTableServiceImpl extends ServiceImpl<RolePowerTableMapper, RolePowerTable>  implements RolePowerTableService{

    @Override
    public List<RolePowerTable> queryById(String rid) {
        List<RolePowerTable> rids = super.query().eq("rid", rid).list();
        return rids;
    }
}
