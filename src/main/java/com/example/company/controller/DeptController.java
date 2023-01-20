package com.example.company.controller;

import com.example.company.model.Department;
import com.example.company.service.DeptService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private static final Logger log = LogManager.getLogger(DeptController.class);

    @Autowired
    DeptService deptService;

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        log.info("Entering into DeptController.getAllDepartments().");
        return deptService.getAllDepartments();
    }

    @GetMapping("/{dId}")
    public Department getDepartmentByDeptId(@PathVariable("dId") Long deptId){
        log.info("Entering into DeptController.getDepartmentByDeptId(@PathVariable(\"dId\") Long deptId). Requested Dept Id - {}", deptId);
        return deptService.getDepartmentByDeptId(deptId);
    }

}
