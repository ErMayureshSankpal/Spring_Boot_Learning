package com.example.company.repo;

import com.example.company.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {

    Long deleteByFirstName(String firstName);

    Employees findByFirstName(String empName);
}
