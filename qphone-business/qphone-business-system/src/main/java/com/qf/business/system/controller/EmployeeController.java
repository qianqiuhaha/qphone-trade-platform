package com.qf.business.system.controller;

import com.qf.business.system.service.EmployeeService;
import com.qf.data.base.r.Codes;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.system.entity.Employee;
import com.qf.data.system.vo.input.EmployeeInput;
import com.qf.data.system.vo.output.EmployeeOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.io.OutputStream;
import java.lang.annotation.ElementType;

/**
 * @author qiu16
 */
@RestController
@RequestMapping("/emp")
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/login")
    public R login(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "密码不能为空") String password, HttpSession session){
        Employee employee = employeeService.login(username, password);
        //登陆后进行用户名权限的判断
        if (employee!=null){
            session.setAttribute("login_emp",employee);
            EmployeeOutput employeeOutput = new EmployeeOutput();
            BeanUtils.copyProperties(employee,employeeOutput);
            System.out.println(Rs.create(employee));
            return Rs.create(employeeOutput);
        }
        return Rs.createFail(Codes.LOGIN_FAIL);


    }
    /**
     * 用户权限注销功能
     */
    @RequestMapping("/logout")
    public R loginOut(HttpSession session){
        System.out.println("用户退出");
        session.removeAttribute("login_emp");
        return Rs.create(Codes.SUCC);
    }

    /**
     * 新增员工接口
     * @return
     */
    @RequestMapping("/insert")
    public R insert(EmployeeInput employeeInput){
        System.out.println(1/0);;
        System.out.println("666");
        Employee employee = new Employee();
        //数据转换
        BeanUtils.copyProperties(employeeInput,employee);
        employeeService.save(employee);
        return Rs.create("succ");
    }
}
