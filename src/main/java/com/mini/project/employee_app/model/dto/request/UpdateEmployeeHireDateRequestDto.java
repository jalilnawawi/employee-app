package com.mini.project.employee_app.model.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UpdateEmployeeHireDateRequestDto {
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date hireDate;
}
