package com.mini.project.employee_app.model.dto.request;

import lombok.Data;

import java.sql.Date;

@Data
public class UpdateEmployeeHireDateRequestDto {
    private Date hireDate;
}
