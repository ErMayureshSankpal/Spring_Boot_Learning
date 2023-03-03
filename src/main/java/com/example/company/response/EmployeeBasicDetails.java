package com.example.company.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonComponent
@XmlRootElement
public class EmployeeBasicDetails {

    @JsonProperty("Employee Id")
    private Long empId;

    @JsonProperty("Employee First Name")
    private String fName;

    @JsonProperty("Employee Last Name")
    private String lName;

    @JsonProperty("Phone Number")
    private String phNum;

    @JsonProperty("Email Id")
    private String email;

    public EmployeeBasicDetails() {
    }

    public EmployeeBasicDetails(Long empId, String fName, String lName, String phNum, String email) {
        this.empId = empId;
        this.fName = fName;
        this.lName = lName;
        this.phNum = phNum;
        this.email = email;
    }

    public Long getEmpId() {
        return empId;
    }

    @XmlElement(name = "EmployeeId")
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getfName() {
        return fName;
    }

    @XmlElement(name = "EmployeeFirstName")
    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    @XmlElement(name = "EmployeeLastName")
    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhNum() {
        return phNum;
    }

    @XmlElement(name = "PhoneNumber")
    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "EmailId")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeBasicDetails{" +
                "empId=" + empId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phNum='" + phNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
