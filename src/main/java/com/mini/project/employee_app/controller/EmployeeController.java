package com.mini.project.employee_app.controller;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeRequestDto;
import com.mini.project.employee_app.model.entity.Employee;
import com.mini.project.employee_app.service.EmployeeService;
import com.mini.project.employee_app.utils.apidocs.ApiResponseAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @ApiResponseAnnotations.CreateEmployeeApiResponses
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreateEmployeeRequestDto createEmployeeRequestDto){
        Employee employee = employeeService.create(createEmployeeRequestDto);
        EntityModel<Employee> entityModel = toHateoasEntityModel(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "success create a new employee");
        response.put("data", entityModel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployee(){
        List<Employee> employee = employeeService.getAllEmployee();
        List<EntityModel<Employee>> employeeModels = employee.stream()
                .map(this::toHateoasEntityModel).toList();

        Link selfLink = linkTo(methodOn(EmployeeController.class).getAllEmployee()).withSelfRel();
        CollectionModel<EntityModel<Employee>> collectionModel = CollectionModel.of(employeeModels, selfLink);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "success get all employees");
        response.put("data", collectionModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{no}")
    public ResponseEntity<Map<String, Object>> getEmployeeByEmpNo(@PathVariable("no") int empNo){
        Employee employee = employeeService.getEmployeeByEmpNo(empNo);
        EntityModel<Employee> entityModel = toHateoasEntityModel(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "success get employee");
        response.put("data", entityModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("{no}")
    public ResponseEntity<Map<String, Object>> updateHireDate(
            @PathVariable("no") int empNo,
            @RequestBody UpdateEmployeeRequestDto updateEmployeeRequestDto
            ){
        Employee employee = employeeService.updateEmployee(empNo, updateEmployeeRequestDto);
        EntityModel<Employee> entityModel = toHateoasEntityModel(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "success update hire date");
        response.put("data", entityModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{no}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable("no") int empNo){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success delete emplopyee");
        response.put("data", employeeService.deleteEmployee(empNo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private EntityModel<Employee> toHateoasEntityModel(Employee employee){
        Link selfLink = linkTo(methodOn(EmployeeController.class).getEmployeeByEmpNo(employee.getNo()))
                .withSelfRel();
        Link allEmployeesLink = linkTo(methodOn(EmployeeController.class).getAllEmployee())
                .withRel("all-employees");
        return EntityModel.of(employee, selfLink, allEmployeesLink);
    }
}
