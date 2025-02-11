package com.mini.project.employee_app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeHireDateRequestDto;
import com.mini.project.employee_app.model.dto.response.DeleteEmployeeResponseDto;
import com.mini.project.employee_app.model.dto.response.UpdateEmployeeHireDateResponseDto;
import com.mini.project.employee_app.model.entity.Employee;
import com.mini.project.employee_app.model.enums.Gender;
import com.mini.project.employee_app.repository.EmployeeRepository;
import com.mini.project.employee_app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    @Test
    void create() {
        CreateEmployeeRequestDto requestDto = new CreateEmployeeRequestDto();
        requestDto.setFirstName("Joko");
        requestDto.setLastName("Purnomo");
        requestDto.setGender("M");
        requestDto.setBirthDate(createDate(1996, 4, 2));
        requestDto.setHireDate(createDate(2025, 2, 25));
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
    void updateHireDate() {
        UpdateEmployeeHireDateRequestDto requestDto = new UpdateEmployeeHireDateRequestDto();
        requestDto.setHireDate(createDate(2025,02,28));

        UpdateEmployeeHireDateResponseDto responseDto = employeeService.updateHireDate(1, requestDto);
        assertEquals(1, responseDto.getEmpNo());
    }

    @Test
    void delete() {
        DeleteEmployeeResponseDto responseDto = employeeService.deleteEmployee(7);
        assertEquals(7, responseDto.getEmpNo());
    }
}