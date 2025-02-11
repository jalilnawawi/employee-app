package com.mini.project.employee_app.utils.apidocs;

import com.mini.project.employee_app.model.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class CreateUserExampleResponse {
    @Schema(example = "5")
    private int no;

    @Schema(example = "Jalil")
    private String firstName;

    @Schema(example = "Nawawi")
    private String lastName;

    @Schema(example = "M")
    private Gender gender;

    @Schema(example = "1998-05-02")
    private LocalDate birthDate;

    @Schema(example = "2025-02-17")
    private LocalDate hireDate;

    @Schema()
    private Map<String, String> links;
}
