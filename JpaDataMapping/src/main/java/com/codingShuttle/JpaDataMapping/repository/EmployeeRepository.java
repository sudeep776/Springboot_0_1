package com.codingShuttle.JpaDataMapping.repository;

import com.codingShuttle.JpaDataMapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
