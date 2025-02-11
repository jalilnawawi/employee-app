package com.mini.project.employee_app.model.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UpdateEmployeeRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate hireDate;
}
