package com.example.EmployeePortal.repository;

import com.example.EmployeePortal.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
