package com.mini.project.employee_app.service.impl;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeHireDateRequestDto;
import com.mini.project.employee_app.model.dto.response.CreateEmployeeResponseDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.dto.response.UpdateEmployeeHireDateResponseDto;
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
    public CreateEmployeeResponseDto create(CreateEmployeeRequestDto createEmployeeRequestDto) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeRequestDto.getFirstName());
        employee.setLastName(createEmployeeRequestDto.getLastName());
        employee.setBirthDate(createEmployeeRequestDto.getBirthDate());
        employee.setHireDate(createEmployeeRequestDto.getHireDate());
        if (createEmployeeRequestDto.getGender().equalsIgnoreCase("m")){
            employee.setGender(Gender.M);
        } else {
            employee.setGender(Gender.F);
        }
        employeeRepository.save(employee);

        CreateEmployeeResponseDto responseDto = new CreateEmployeeResponseDto();
        responseDto.setEmpNo(employee.getNo());
        responseDto.setFirstName(employee.getFirstName());
        responseDto.setLastName(employee.getLastName());
        responseDto.setBirthDate(employee.getBirthDate());
        responseDto.setGender(employee.getGender());
        responseDto.setHireDate(employee.getHireDate());
        return responseDto;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmpNo(int empNo) {
        return employeeRepository.findById(empNo).orElse(null);
    }

    @Override
    public UpdateEmployeeHireDateResponseDto updateHireDate(int empNo, UpdateEmployeeHireDateRequestDto hireDateRequestDto) {
        Employee employee = employeeRepository.findById(empNo).orElse(null);
        employee.setHireDate(hireDateRequestDto.getHireDate());
        employeeRepository.save(employee);

        UpdateEmployeeHireDateResponseDto responseDto = new UpdateEmployeeHireDateResponseDto();
        responseDto.setEmpNo(employee.getNo());
        responseDto.setFirstName(employee.getFirstName());
        responseDto.setLastName(employee.getLastName());
        responseDto.setHireDate(employee.getHireDate());
        return responseDto;
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
