package com.example.company.repo;

import com.example.company.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department, Long> {
    Department findByDeptId(Long deptId);
}
