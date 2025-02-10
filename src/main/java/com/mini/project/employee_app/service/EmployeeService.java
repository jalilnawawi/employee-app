package com.mini.project.employee_app.service;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeHireDateRequestDto;
import com.mini.project.employee_app.model.dto.response.CreateEmployeeResponseDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.dto.response.UpdateEmployeeHireDateResponseDto;
import com.mini.project.employee_app.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    CreateEmployeeResponseDto create(CreateEmployeeRequestDto createEmployeeRequestDto);
    List<Employee> getAllEmployee();
    Employee getEmployeeByEmpNo(int empNo);
    UpdateEmployeeHireDateResponseDto updateHireDate(int empNo, UpdateEmployeeHireDateRequestDto hireDateRequestDto);
    DeleteEmployeeResponseDto deleteEmployee(int empNo);
}
