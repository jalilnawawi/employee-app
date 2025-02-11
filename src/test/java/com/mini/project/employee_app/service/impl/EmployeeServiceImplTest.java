package com.mini.project.employee_app.service.impl;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.entity.Employee;
import com.mini.project.employee_app.repository.EmployeeRepository;
import com.mini.project.employee_app.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    void create() {
        CreateEmployeeRequestDto requestDto = new CreateEmployeeRequestDto();
        requestDto.setFirstName("Joko");
        requestDto.setLastName("Purnomo");
        requestDto.setGender("M");
        requestDto.setBirthDate(LocalDate.of(1996, 4, 2));
        requestDto.setHireDate(LocalDate.of(2025, 2, 25));
        employeeService.create(requestDto);

        Employee employee = employeeRepository.findById(4).orElse(null);
        assertNotNull(employee);
        assertEquals("Joko", employee.getFirstName());
    }

    @Test
    void getAll() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        assertNotNull(employeeList);
        assertEquals(3, employeeList.size());
    }

    @Test
    void getByEmpNo() {
        Employee employeeByEmpNo = employeeService.getEmployeeByEmpNo(1);
        assertNotNull(employeeByEmpNo);
        assertEquals("Abdul", employeeByEmpNo.getFirstName());
    }

    @Test
    void updateEmployee() {
        UpdateEmployeeRequestDto updateEmployeeRequestDto = new UpdateEmployeeRequestDto();
        updateEmployeeRequestDto.setFirstName("Budi");
        updateEmployeeRequestDto.setLastName("Sudarsono");
        updateEmployeeRequestDto.setBirthDate(LocalDate.of(1987,8,1));
        updateEmployeeRequestDto.setHireDate(LocalDate.of(2025,2,19));
        Employee employee = employeeService.updateEmployee(2, updateEmployeeRequestDto);

        assertNotNull(employee);
        assertEquals("Sudarsono", employee.getLastName());
    }

    @Test
    void delete() {
        Employee employee = employeeService.getEmployeeByEmpNo(11);
        assertNotNull(employee);

        DeleteEmployeeResponseDto responseDto = employeeService.deleteEmployee(11);
        assertEquals(11, responseDto.getEmpNo());
    }
}