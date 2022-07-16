package com.qf.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.data.system.dto.PowerDto;
import com.qf.data.system.entity.Power;

import java.util.List;

/**
 * @author qiu16
 */

public interface PowerService extends IService<Power> {

    List<PowerDto> queryList();
}
