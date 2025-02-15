package com.codingShuttle.sudeep.prod_features.prod_features.clients;

import com.codingShuttle.sudeep.prod_features.prod_features.dto.EmployeeDto;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long EmployeeId);

    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
}
