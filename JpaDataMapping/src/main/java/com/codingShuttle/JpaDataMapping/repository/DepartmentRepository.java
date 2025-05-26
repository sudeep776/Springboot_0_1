package com.codingShuttle.JpaDataMapping.repository;

import com.codingShuttle.JpaDataMapping.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
