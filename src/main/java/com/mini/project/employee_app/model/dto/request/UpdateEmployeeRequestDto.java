package com.mini.project.employee_app.model.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class UpdateEmployeeRequestDto {
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate hireDate;
}
