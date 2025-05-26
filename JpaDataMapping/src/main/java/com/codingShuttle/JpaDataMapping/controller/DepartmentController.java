package com.codingShuttle.JpaDataMapping.controller;

import com.codingShuttle.JpaDataMapping.entities.Department;
import com.codingShuttle.JpaDataMapping.repository.DepartmentRepository;
import com.codingShuttle.JpaDataMapping.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department createNewDepartment(@RequestBody Department department){
        return departmentService.createNewDepartment(department);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    public Department assignManagerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(departmentId,employeeId);
    }
}

