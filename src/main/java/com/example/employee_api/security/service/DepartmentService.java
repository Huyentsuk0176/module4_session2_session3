package com.example.employee_api.security.service;

import com.example.employee_api.dto.request.DepartmentDTO;
import com.example.employee_api.model.Department;

public interface DepartmentService {

    Department create(DepartmentDTO dto);

}