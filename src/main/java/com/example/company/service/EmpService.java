package com.example.company.service;

import com.example.company.model.Department;
import com.example.company.model.Employees;
import com.example.company.repo.DeptRepo;
import com.example.company.repo.EmployeeRepo;
import com.example.company.response.EmployeeBasicDetails;
import com.example.company.response.EmploymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DeptRepo deptRepo;

    public List<Employees> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public ResponseEntity<String> addEmployee(Employees employees){
        employeeRepo.save(employees);
        return ResponseEntity.ok("Employee added successfully.");
    }

    public ResponseEntity<String> deleteEmployeeById(Long empId) {

        Optional<Employees> emp = employeeRepo.findById(empId);
        employeeRepo.deleteById(empId);
        return ResponseEntity.ok("Employee deleted of Name - "+emp.get().getFirstName());
    }

    public ResponseEntity<String> deleteEmployeeByName(String empName) {
        employeeRepo.deleteByFirstName(empName);
        return ResponseEntity.ok("Employee deleted of Name - "+empName);
    }

    public ResponseEntity<EmployeeBasicDetails> getEmpByEmpName(String empName) {
        Employees emp = employeeRepo.findByFirstName(empName);

        return ResponseEntity.ok(new EmployeeBasicDetails(emp.getEmployeeId(), emp.getFirstName(),
                emp.getLastName(),emp.getPhoneNumber(),emp.getEmail()));
    }

    public ResponseEntity<EmployeeBasicDetails> getEmploymentDetailsByEmpName(String empName) {
        Employees emp = employeeRepo.findByFirstName(empName);
        Employees mgr = employeeRepo.findById(emp.getManagerId()).get();
        Department dept = deptRepo.findByDeptId(emp.getDepartmentId());

        return ResponseEntity.ok(new EmploymentDetails(emp.getEmployeeId(), emp.getFirstName(),
                emp.getLastName(),emp.getPhoneNumber(),emp.getEmail(), emp.getSalary(),
                mgr.getFirstName()+" "+mgr.getLastName(), dept.getDeptName(), emp.getHireDate()));
    }
}
