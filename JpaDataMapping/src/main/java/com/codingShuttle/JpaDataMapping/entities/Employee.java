package com.codingShuttle.JpaDataMapping.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "manager",cascade = CascadeType.ALL)
    @JsonIgnore
    private Department managedDept;

    @ManyToOne
    @JoinColumn(name = "worker_dept_id",referencedColumnName = "id")
    @JsonIgnore
    private Department workerDept;

    @ManyToMany
    @JoinTable(name = "freelance_dept_mapping",
    joinColumns = @JoinColumn(name = "emp_id"),
    inverseJoinColumns = @JoinColumn(name = "dept_id")
    )
    private Set<Department> freelanceDepartments;
}
