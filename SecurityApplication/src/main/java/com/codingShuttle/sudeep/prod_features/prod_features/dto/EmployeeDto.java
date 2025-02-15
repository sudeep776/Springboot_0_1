package com.codingShuttle.sudeep.prod_features.prod_features.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private LocalDate dateOfJoining;
    private Double salary;
    private Boolean isActive;
}
