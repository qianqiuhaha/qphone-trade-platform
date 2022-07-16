package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.system.mapper.DepartmentMapper;
import com.qf.business.system.service.DepartmentService;
import com.qf.data.system.entity.Department;
import org.springframework.stereotype.Service;

/**
 * @author qiu16
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
