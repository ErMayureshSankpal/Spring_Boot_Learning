package com.example.company.service;

import com.example.company.model.Department;
import com.example.company.repo.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptRepo deptRepo;

    public List<Department> getAllDepartments(){
        return deptRepo.findAll();
    }

    public Department getDepartmentByDeptId(Long deptId) {
        return deptRepo.findByDeptId(deptId);
    }
}
