package com.example.employee_api.service;

import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Danh sách nhân viên
    private List<Employee> employees = new ArrayList<>();

    // ID tự tăng
    private Long currentId = 4L;

    // Constructor chứa dữ liệu mẫu
    public EmployeeServiceImpl() {
        employees.add(new Employee(1L, "Tuan", "IT", 2000.0));
        employees.add(new Employee(2L, "Lan", "HR", 1800.0));
        employees.add(new Employee(3L, "Tuan", "Marketing", 2200.0));
    }

    // ===========================
    // 🔥 BÀI 4 - ĐỌC DỮ LIỆU
    // ===========================

    // 1. Lấy tất cả nhân viên
    @Override
    public List<Employee> getAll() {
        return employees;
    }

    // 2. Lấy theo ID
    @Override
    public Employee findById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 3. Tìm theo tên
    @Override
    public List<Employee> findByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // 4. Tìm theo filter (name + department)
    @Override
    public List<Employee> filter(EmployeeFilter filter) {
        return employees.stream()
                .filter(e -> (filter.getName() == null || e.getName().equalsIgnoreCase(filter.getName())))
                .filter(e -> (filter.getDepartment() == null || e.getDepartment().equalsIgnoreCase(filter.getDepartment())))
                .collect(Collectors.toList());
    }

    // ===========================
    // 🔥 BÀI 5 - GHI DỮ LIỆU
    // ===========================

    // 5. Thêm mới nhân viên (POST)
    @Override
    public Employee create(Employee employee) {
        employee.setId(currentId++);   // Tự tăng ID
        employees.add(employee);
        return employee;
    }

    // 6. Cập nhật nhân viên (PUT)
    @Override
    public Employee update(Long id, Employee employee) {

        Employee existing = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existing != null) {
            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());
        }

        return existing;
    }

    // 7. Xóa nhân viên (DELETE)
    @Override
    public void delete(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}