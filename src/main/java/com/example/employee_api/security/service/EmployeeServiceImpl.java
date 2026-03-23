package com.example.employee_api.security.service;

import com.example.employee_api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setId(1L);
        e1.setFullName("Nguyen Van A");
        e1.setSalary(1000.0);

        Employee e2 = new Employee();
        e2.setId(2L);
        e2.setFullName("Tran Thi B");
        e2.setSalary(1200.0);

        Employee e3 = new Employee();
        e3.setId(3L);
        e3.setFullName("Le Van C");
        e3.setSalary(1500.0);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        return employees;
    }
}