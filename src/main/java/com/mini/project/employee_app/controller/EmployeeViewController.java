package com.mini.project.employee_app.controller;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeRequestDto;
import com.mini.project.employee_app.model.entity.Employee;
import com.mini.project.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeViewController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("employee", new Employee());
        return "employees/list";
    }

    @GetMapping("/add-employee-form")
    public String showAddForm(Model model) {
        model.addAttribute("employeeRequestDto", new CreateEmployeeRequestDto());
        return "employees/add-employee-form";
    }

    @PostMapping("/save-new-employee")
    public String saveNewEmployee(@ModelAttribute CreateEmployeeRequestDto employeeRequestDto){
        employeeService.create(employeeRequestDto);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee-form/{no}")
    public String showEditForm(@PathVariable("no") int empNo, Model model) {
        Employee employee = employeeService.getEmployeeByEmpNo(empNo);

        UpdateEmployeeRequestDto updateEmployeeRequestDto = new UpdateEmployeeRequestDto();
        updateEmployeeRequestDto.setFirstName(employee.getFirstName());
        updateEmployeeRequestDto.setLastName(employee.getLastName());
        updateEmployeeRequestDto.setBirthDate(employee.getBirthDate());
        updateEmployeeRequestDto.setHireDate(employee.getHireDate());

        model.addAttribute("updateEmployeeRequestDto", updateEmployeeRequestDto);
        model.addAttribute("employee", employee);

        return "employees/edit-employee-form";
    }

    @PostMapping("/save-edit-employee/{no}")
    public String saveEditEmployee(
            @PathVariable("no") int empNo,
            @ModelAttribute UpdateEmployeeRequestDto updateEmployeeRequestDto){
        employeeService.updateEmployee(empNo, updateEmployeeRequestDto);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{no}")
    public String deleteEmployee(@PathVariable("no") int empNo){
        employeeService.deleteEmployee(empNo);
        return "redirect:/employees";
    }
}
