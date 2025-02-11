package com.mini.project.employee_app.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int empNo){
        super("Employee with No " + empNo + " is not found");
    }
}
