package com.example.EmployeePortal.service;

import com.example.EmployeePortal.models.Employee;
import com.example.EmployeePortal.models.EmployeeList;
import com.example.EmployeePortal.repository.EmployeeRepository;
import com.example.EmployeePortal.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeValidator employeeValidator;

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeList getEmployees(){
        EmployeeList employeeList = new EmployeeList();
        List<Employee> employees = employeeRepository.findAll();
        employeeList.setEmployees(employees);
        return employeeList;
    }

    public Employee getEmployee(long employeeId , String country){
        return employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("ID doesn't exist : " + employeeId));
    }


    public String createEmployee(Employee employee){
        employeeValidator.validateEmployee(employee);
        Employee savedEmployee = employeeRepository.save(employee);
        return "Successfully created Employee ID : " + savedEmployee.getId();
    }


    public String updateEmployee(Long employeeId, Employee employee){
        employeeValidator.validateEmployeeForUpdate(employee, employeeId);

        employee.setId(employeeId);
        employeeRepository.save(employee);
        return  "Updated";
    }


    public String deleteEmployee(Long employeeId){
        employeeValidator.validateEmployeeId(employeeId);

        employeeRepository.deleteById(employeeId);
        return "Deleted";
    }
}
