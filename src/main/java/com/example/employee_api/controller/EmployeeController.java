package com.example.employee_api.controller;

import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import com.example.employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ===============================
    // 1️⃣ @PathVariable
    // URL: /api/employees/{id}
    // ===============================
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    // ===============================
    // 2️⃣ @RequestParam
    // URL: /api/employees/search?name=Tuan
    // ===============================
    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    // ===============================
    // 3️⃣ @ModelAttribute
    // URL: /api/employees/filter?name=Tuan&department=IT
    // ===============================
    @GetMapping("/filter")
    public List<Employee> filterEmployees(@ModelAttribute EmployeeFilter filter) {
        return employeeService.filter(filter);
    }
}
