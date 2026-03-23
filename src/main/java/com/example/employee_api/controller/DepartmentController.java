package com.example.employee_api.controller;

import com.example.employee_api.dto.request.DepartmentDTO;
import com.example.employee_api.dto.response.ApiResponse;
import com.example.employee_api.model.Department;
import com.example.employee_api.security.service.DepartmentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ApiResponse<Department> create(@Valid @RequestBody DepartmentDTO dto) {

        Department department = departmentService.create(dto);

        return new ApiResponse<>(
                "SUCCESS",
                "Tạo phòng ban thành công",
                department
        );
    }
}
