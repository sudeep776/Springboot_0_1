package com.codingShuttle.JpaDataMapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToOne
    @JoinColumn(name = "department_manager")
    private Employee manager;

    @OneToMany(mappedBy = "workerDept")
    private Set<Employee> workers;

    @ManyToMany(mappedBy = "freelanceDepartments")
    private Set<Employee> freelancers;
}
