package com.mini.project.employee_app.utils.apidocs;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

public class ApiResponseAnnotations {

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success create a new employee",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CreateUserExampleResponse.class)
                            )
                    }
            )
    })
    public @interface CreateEmployeeApiResponses{
    }
}
