package com.mini.project.employee_app.model.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class DeleteEmployeeResponseDto {
    private int empNo;
    private String firstName;
    private Date hireDate;
}
