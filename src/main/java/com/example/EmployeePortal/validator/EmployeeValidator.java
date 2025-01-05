package com.example.EmployeePortal.validator;

import com.example.EmployeePortal.models.Employee;
import com.example.EmployeePortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    @Autowired
    EmployeeRepository employeeRepository;

    public void validateEmployee(Employee employee) {
        if(!employee.getFirstName().matches("[a-zA-Z]+")) {
            throw new RuntimeException("Invalid firstName");
        }
    }

    public void validateEmployeeForUpdate(Employee employee, Long employeeId) {
        validateEmployeeId(employeeId);
        validateEmployee(employee);
    }

    public void validateEmployeeId(Long employeeId) {
        if(!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("ID doesn't exist : " + employeeId);
        }
    }

}
