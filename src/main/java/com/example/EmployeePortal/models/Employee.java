package com.example.EmployeePortal.models;

import lombok.Data;

@Data
public class Employee {
    public Employee(String fristname, String lastname, String department) {
        this.fristname = fristname;
        this.lastname = lastname;
        this.department = department;
    }

    private String fristname;
    private String lastname;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private String department;

}
