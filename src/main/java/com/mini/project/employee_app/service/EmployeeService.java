package com.mini.project.employee_app.service;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeRequestDto createEmployeeRequestDto);
    List<Employee> getAllEmployee();
    Employee getEmployeeByEmpNo(int empNo);
    Employee updateEmployee(int empNo, UpdateEmployeeRequestDto updateEmployeeRequestDto);
    DeleteEmployeeResponseDto deleteEmployee(int empNo);
}
