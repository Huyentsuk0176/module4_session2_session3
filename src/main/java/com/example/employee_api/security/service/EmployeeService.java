package com.example.employee_api.security.service;

import com.example.employee_api.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}