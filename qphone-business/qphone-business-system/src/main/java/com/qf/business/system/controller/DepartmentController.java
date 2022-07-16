package com.qf.business.system.controller;

import com.qf.business.system.service.DepartmentService;
import com.qf.data.base.r.R;
import com.qf.data.base.r.Rs;
import com.qf.data.system.entity.Department;
import com.qf.data.system.vo.input.DepartmentInput;
import com.qf.data.system.vo.output.DepListOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /**
     * 部门列表的查询
     */
    @RequestMapping("/list")
    public R depList(){
        //部门查询
        System.out.println("触发部门查询");
        List<Department> deplist = departmentService.list();
        List<DepListOutput> depListOut=deplist.stream().map(department -> {
            DepListOutput depListOutput = new DepListOutput();
            BeanUtils.copyProperties(department, depListOutput);
            return depListOutput;

        }).collect(Collectors.toList());
        return Rs.create(depListOut);
    }
    /**
     * 新增部门的接口
     */
    @RequestMapping("/insert")
    public R inserDep(@Validated DepartmentInput depInput){

        Department department = new Department();
        BeanUtils.copyProperties(depInput,department);
        departmentService.save(department);
        return Rs.create("succ");
    }
    /**
     *
     */
}
