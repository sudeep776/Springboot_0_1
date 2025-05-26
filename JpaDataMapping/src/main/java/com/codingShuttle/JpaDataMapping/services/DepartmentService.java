package com.codingShuttle.JpaDataMapping.services;

import com.codingShuttle.JpaDataMapping.entities.Department;
import com.codingShuttle.JpaDataMapping.entities.Employee;
import com.codingShuttle.JpaDataMapping.repository.DepartmentRepository;
import com.codingShuttle.JpaDataMapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }


    public Department createNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department assignManagerToDepartment(Long departmentId, Long employeeId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        assert department != null;
        department.setManager(employee);
        return departmentRepository.save(department);
    }
}
