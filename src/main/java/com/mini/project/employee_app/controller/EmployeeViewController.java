package com.mini.project.employee_app.controller;

import com.mini.project.employee_app.model.dto.request.CreateEmployeeRequestDto;
import com.mini.project.employee_app.model.dto.request.UpdateEmployeeHireDateRequestDto;
import com.mini.project.employee_app.model.dto.response.UpdateEmployeeHireDateResponseDto;
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

    @GetMapping("/form")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute CreateEmployeeRequestDto employeeRequestDto){
        employeeService.create(employeeRequestDto);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{no}")
    public String showEditForm(@PathVariable("no") int empNo, @ModelAttribute UpdateEmployeeHireDateRequestDto requestDto) {
        employeeService.updateHireDate(empNo, requestDto);
        return "employees/form";
    }
}
