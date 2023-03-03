package com.example.company.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@JsonComponent
@XmlRootElement
public class EmploymentDetails extends EmployeeBasicDetails{

    @JsonProperty("Salary per month")
    private Double sal;

    @JsonProperty("Reporting Manager")
    private String managerName;

    @JsonProperty("Department Name")
    private String deptName;

    @JsonProperty("Joining Date")
    private Date hierDate;

    public EmploymentDetails() {
    }

    public EmploymentDetails(Long empId, String fName, String lName, String phNum, String email, Double sal, String managerName, String deptName, Date hierDate) {
        super(empId, fName, lName, phNum, email);
        this.sal = sal;
        this.managerName = managerName;
        this.deptName = deptName;
        this.hierDate = hierDate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getHierDate() {
        return hierDate;
    }

    public void setHierDate(Date hierDate) {
        this.hierDate = hierDate;
    }

    @Override
    public String toString() {
        return "EmploymentDetails{" +
                "sal=" + sal +
                ", managerName='" + managerName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", hierDate=" + hierDate +
                '}';
    }
}
