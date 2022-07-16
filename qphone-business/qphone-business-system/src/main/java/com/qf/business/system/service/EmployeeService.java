package com.qf.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.data.system.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService extends IService<Employee> {
    /**
     * 用户登录接口
     * @param username
     * @param password
     * @return
     */
    Employee login(String username,String password);

}
