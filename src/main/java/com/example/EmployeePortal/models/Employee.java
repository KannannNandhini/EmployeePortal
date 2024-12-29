package com.example.EmployeePortal.models;

public class Employee {
    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    private String firstName;
    private String lastName;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
