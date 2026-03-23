package com.example.employee_api.security.service.impl;

import com.example.employee_api.dto.request.DepartmentDTO;
import com.example.employee_api.mapper.DepartmentMapper;
import com.example.employee_api.model.Department;
import com.example.employee_api.security.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private List<Department> departments = new ArrayList<>();
    private Long idCounter = 1L;

    @Autowired
    private DepartmentMapper mapper;

    @Override
    public Department create(DepartmentDTO dto) {

        Department department = mapper.toEntity(dto);

        department.setId(idCounter++);

        departments.add(department);

        return department;
    }
}