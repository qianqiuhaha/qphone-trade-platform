package com.qf.business.system.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.business.system.mapper.EmployeeMapper;
import com.qf.business.system.service.EmployeeService;
import com.qf.data.system.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public Employee login(String username, String password) {
        Employee employee = super.query().eq("username", username).eq("password", password).one();
        return employee;
    }
}
