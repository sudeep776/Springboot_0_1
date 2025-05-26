package com.codingShuttle.JpaDataMapping.controller;

import com.codingShuttle.JpaDataMapping.entities.Employee;
import com.codingShuttle.JpaDataMapping.repository.EmployeeRepository;
import com.codingShuttle.JpaDataMapping.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee){
        System.out.println(employee.getName());
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/addEmployee")
    public String addEmployee(){
       Employee emp= Employee.builder().id(1L).name("Sudeep").build();
        employeeService.createNewEmployee(emp);
        return "Employee added";
    }

}
