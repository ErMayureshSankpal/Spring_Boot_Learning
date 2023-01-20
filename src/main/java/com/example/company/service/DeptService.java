package com.example.company.service;

import com.example.company.controller.CountriesController;
import com.example.company.model.Department;
import com.example.company.repo.DeptRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    private static final Logger log = LogManager.getLogger(DeptService.class);
    @Autowired
    DeptRepo deptRepo;

    public List<Department> getAllDepartments(){
        log.info("Entering into DeptService.getAllDepartments().");
        return deptRepo.findAll();
    }

    public Department getDepartmentByDeptId(Long deptId) {
        log.info("Entering into DeptService.getDepartmentByDeptId(Long deptId) with Dept Id - {}.",deptId);
        return deptRepo.findByDeptId(deptId);
    }
}
