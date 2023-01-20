package com.example.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Long deptId;

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String deptName;

    @Column(name = "MANAGER_ID")
    private Long managerId;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    public Department() {
    }

    public Department(Long deptId, String deptName, Long managerId, Long locationId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", managerId=" + managerId +
                ", locationId=" + locationId +
                '}';
    }
}
