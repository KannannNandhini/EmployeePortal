package com.example.EmployeePortal.controller;

import com.example.EmployeePortal.models.Employee;
import com.example.EmployeePortal.models.EmployeeList;
import com.example.EmployeePortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public EmployeeList getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{employeeId}/{country}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long employeeId, @PathVariable String country){
        try {
            return new ResponseEntity<>(employeeService.getEmployee(employeeId, country), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        try {
            return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String>updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee){
        try {
            return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employee), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        try {
            return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
