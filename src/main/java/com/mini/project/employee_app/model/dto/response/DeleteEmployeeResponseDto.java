package com.mini.project.employee_app.model.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class DeleteEmployeeResponseDto {
    private int empNo;
    private String firstName;
    private LocalDate hireDate;
}
