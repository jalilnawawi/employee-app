package com.mini.project.employee_app.model.dto.request;

import com.mini.project.employee_app.model.enums.Gender;
import lombok.Data;
import java.util.Date;

@Data
public class CreateEmployeeRequestDto {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private Date hireDate;
}
