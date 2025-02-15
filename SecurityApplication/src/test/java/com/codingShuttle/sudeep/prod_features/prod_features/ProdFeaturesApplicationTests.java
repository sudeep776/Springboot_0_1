package com.codingShuttle.sudeep.prod_features.prod_features;

//import com.codingShuttle.sudeep.prod_features.prod_features.clients.EmployeeClient;
//import com.codingShuttle.sudeep.prod_features.prod_features.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdFeaturesApplicationTests {

//	@Autowired
//	EmployeeClient employeeClient;

	@Test
	void contextLoads() {
	}
//
//	@Test
//	void getAllEmployees(){
//		List<EmployeeDto> employeeDtoList = employeeClient.getAllEmployees();
//		System.out.println(employeeDtoList);
// 	}
//
//	 @Test
//	void getEmployeeById(){
//		EmployeeDto employeeDto=employeeClient.getEmployeeById(1L);
//		 System.out.println(employeeDto);
//	 }
//
//	 @Test
//	void createEmployee(){
//		EmployeeDto employeeDto = new EmployeeDto(null,"Anuj","anuj@gmail.com",2,"USER",LocalDate.of(2020,12,1),5000.00,true);
//		EmployeeDto savedEmp = employeeClient.createNewEmployee(employeeDto);
//		 System.out.println(savedEmp);
//	 }
}
