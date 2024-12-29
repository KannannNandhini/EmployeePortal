package com.example.EmployeePortal.controller;

import com.example.EmployeePortal.models.Employee;
import com.example.EmployeePortal.models.EmployeeList;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public EmployeeList getEmployee(){
        EmployeeList employeeList =new EmployeeList();
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("nandhu","k","cs"));
        employees.add(new Employee("mounish","v","cs"));
        employeeList.setEmployees(employees);
        return employeeList;
    }

    @GetMapping("/{employeeId}/{country}")
    public Employee getEmployeeID(@PathVariable long employeeId ,String country){
        return new Employee("nandhu","k","cs");
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee){
        return "successfuly Created " ;
    }

    @PutMapping("/{employeeId}")
    public String UpdateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee){
         return  "Updated";
    }

    @DeleteMapping("/{employeedId}")
    public String deleteEmployee(@PathVariable Long employeeId){
        return "Deleted";
    }
}
