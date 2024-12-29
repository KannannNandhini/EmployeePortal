package com.example.EmployeePortal.controller;

import com.example.EmployeePortal.models.Employee;
import com.example.EmployeePortal.models.EmployeeList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/all")
    public EmployeeList getEmployees(){
        EmployeeList employeeList=new EmployeeList();
        List<Employee> employees =new ArrayList<Employee>();
        employees.add(new Employee("nandhu","k","cs"));
        employees.add(new Employee("nandh","km","cse"));
        employeeList.setEmployees(employees);
        return employeeList;
    }
}
