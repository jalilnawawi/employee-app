package com.mini.project.employee_app.model.dto.response;

import com.mini.project.employee_app.model.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeResponseDto {
    private int empNo;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private Date hireDate;
}
