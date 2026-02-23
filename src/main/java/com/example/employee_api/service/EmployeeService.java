package com.example.employee_api.service;
import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1L, "Tuan", "IT"));
        employees.add(new Employee(2L, "Lan", "HR"));
        employees.add(new Employee(3L, "Tuan", "Marketing"));
    }

    // 1. Tìm theo ID
    public Employee findById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 2. Tìm theo name
    public List<Employee> findByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // 3. Tìm theo filter
    public List<Employee> filter(EmployeeFilter filter) {
        return employees.stream()
                .filter(e ->
                        (filter.getName() == null || e.getName().equalsIgnoreCase(filter.getName())) &&
                                (filter.getDepartment() == null || e.getDepartment().equalsIgnoreCase(filter.getDepartment()))
                )
                .collect(Collectors.toList());
    }
}
