package com.example.company.controller;


import com.example.company.model.Employees;
import com.example.company.response.EmployeeBasicDetails;
import com.example.company.service.EmpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private static final Logger log = LogManager.getLogger(EmpController.class);

    @Autowired
    EmpService empService;

    @GetMapping("/all")
    public List<Employees> getAllEmployeesList(){
        log.info("Entering into EmpController.getAllEmployeesList().");
        return empService.getAllEmployees();
    }

    @PostMapping("/saveEmp")
    public ResponseEntity<String> saveEmployee(@RequestBody Employees employees){
        log.info("Entering into EmpController.saveEmployee(@RequestBody Employees employees).");
        return empService.addEmployee(employees);
    }

    @DeleteMapping("/delEmp/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long empId){
        log.info("Entering into EmpController.deleteEmployeeById(@PathVariable(\"id\") Long empId).");
        return empService.deleteEmployeeById(empId);
    }

    @DeleteMapping("/delEmp")
    @Transactional
    public ResponseEntity<String> deleteEmpByEmpName(@RequestParam("eName") String empName){
        /*Whenever we use custom delete we must use @Transactional*/
        /*https://stackoverflow.com/questions/31346356/spring-data-jpa-deleteby-query-not-working*/
        log.info("Entering into EmpController.deleteEmpByEmpName(@RequestParam(\"eName\") String empName).");
        return empService.deleteEmployeeByName(empName);
    }

    @GetMapping("/empDtails/{empName}")
    public ResponseEntity<EmployeeBasicDetails> getEmpBasicDetails(@PathVariable String empName){
        log.info("Entering into EmpController.getEmpBasicDetails(@PathVariable String empName).");
        return empService.getEmpByEmpName(empName);
    }

    @GetMapping("/employmentDetails/{empName}")
    public ResponseEntity<EmployeeBasicDetails> getEmpEmploymentDetails(@PathVariable String empName){
        log.info("Entering into EmpController.getEmpEmploymentDetails(@PathVariable String empName).");
        return empService.getEmploymentDetailsByEmpName(empName);
    }
}
