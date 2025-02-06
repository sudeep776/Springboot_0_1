package com.codingShuttle.SpringbootWebtutorial.dto;

import com.codingShuttle.SpringbootWebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "name cannot be blank")
    private String name;
    private String email;
    @Max(value = 60 , message = "max age must be below 60")
    @Min(value = 18 ,message = "min age must be 18")
    private Integer age;
    @NotBlank(message = "role cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role;
    @PastOrPresent(message = "date cant be of the future")
    private LocalDate dateOfJoining;
    @NotNull
    @Positive
    @Digits(integer = 6,fraction = 0, message = "should be of the type XXXXXX")
    private Double salary;
    @AssertTrue(message = "employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
