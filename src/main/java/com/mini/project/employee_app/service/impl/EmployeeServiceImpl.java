package com.mini.project.employee_app.service.impl;

import com.mini.project.employee_app.exception.EmployeeNotFoundException;
import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.entity.Employee;
import com.mini.project.employee_app.model.enums.Gender;
import com.mini.project.employee_app.repository.EmployeeRepository;
import com.mini.project.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee create(CreateEmployeeRequestDto createEmployeeRequestDto) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeRequestDto.getFirstName());
        employee.setLastName(createEmployeeRequestDto.getLastName());
        employee.setBirthDate(createEmployeeRequestDto.getBirthDate());
        employee.setHireDate(createEmployeeRequestDto.getHireDate());
        employee.setGender(Gender.valueOf(createEmployeeRequestDto.getGender()));

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmpNo(int empNo) {
        return employeeRepository.findById(empNo)
                .orElseThrow(() -> new EmployeeNotFoundException(empNo));
    }

    @Override
    public Employee updateEmployee(int empNo, UpdateEmployeeRequestDto updateEmployeeRequestDto) {
        Employee employee = employeeRepository.findById(empNo)
                .orElseThrow(() -> new EmployeeNotFoundException(empNo));
        employee.setFirstName(updateEmployeeRequestDto.getFirstName());
        employee.setLastName(updateEmployeeRequestDto.getLastName());
        employee.setBirthDate(updateEmployeeRequestDto.getBirthDate());
        employee.setHireDate(updateEmployeeRequestDto.getHireDate());

        return employeeRepository.save(employee);
    }

    @Override
    public DeleteEmployeeResponseDto deleteEmployee(int empNo) {
        Employee employee = employeeRepository.findById(empNo).orElse(null);
        employeeRepository.delete(employee);

        DeleteEmployeeResponseDto responseDto = new DeleteEmployeeResponseDto();
        responseDto.setEmpNo(employee.getNo());
        responseDto.setFirstName(employee.getFirstName());
        responseDto.setHireDate(employee.getHireDate());
        return responseDto;
    }
}
