package com.codingShuttle.sudeep.prod_features.prod_features.clients.Impl;

import com.codingShuttle.sudeep.prod_features.prod_features.advices.ApiResponse;
import com.codingShuttle.sudeep.prod_features.prod_features.clients.EmployeeClient;
import com.codingShuttle.sudeep.prod_features.prod_features.dto.EmployeeDto;
import com.codingShuttle.sudeep.prod_features.prod_features.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    @Autowired
    private final RestClient restClient;

    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDto> getAllEmployees() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        logger.trace("GetallEmployees retrieval");
        try{
            ApiResponse<List<EmployeeDto>> employeeDtoList =restClient.get().uri("employees").retrieve().body(new ParameterizedTypeReference<>() {
            });
            logger.debug("Successfully retrived employees");
            logger.trace("Retrived employees");
            return employeeDtoList.getData();
        }
        catch (Exception e){
            logger.error("Exception occured getAllEmployees",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        try{
            ApiResponse<EmployeeDto> employeeDto = restClient.get().uri("employees/{employeeId}",employeeId)
                    .retrieve().body(new ParameterizedTypeReference<ApiResponse<EmployeeDto>>() {
                    });
            return employeeDto.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        try{
            ApiResponse<EmployeeDto> employeeDtoApiResponse = restClient.post().uri("employees")
                    .body(employeeDto).retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println(new String("Error occurred"+res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("employee not created");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDtoApiResponse.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
