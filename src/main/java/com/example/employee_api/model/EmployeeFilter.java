package com.example.employee_api.model;

public class EmployeeFilter {

    private String name;
    private String department;

    public EmployeeFilter() {
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
