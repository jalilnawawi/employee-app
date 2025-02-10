package com.mini.project.employee_app.controller;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeHireDateRequestDto;
import com.mini.project.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreateEmployeeRequestDto createEmployeeRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success create a new employee");
        response.put("data", employeeService.create(createEmployeeRequestDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployee(){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success get all employees");
        response.put("data", employeeService.getAllEmployee());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{no}")
    public ResponseEntity<Map<String, Object>> getEmployeeByEmpNo(@PathVariable("no") int empNo){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success get employee");
        response.put("data", employeeService.getEmployeeByEmpNo(empNo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("{no}")
    public ResponseEntity<Map<String, Object>> updateHireDate(
            @PathVariable("no") int empNo,
            @RequestBody UpdateEmployeeHireDateRequestDto updateHireDate
            ){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success update hire date");
        response.put("data", employeeService.updateHireDate(empNo, updateHireDate));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{no}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable("no") int empNo){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success delete emplopyee");
        response.put("data", employeeService.deleteEmployee(empNo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
