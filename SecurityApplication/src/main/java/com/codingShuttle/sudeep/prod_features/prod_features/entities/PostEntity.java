package com.codingShuttle.sudeep.prod_features.prod_features.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "Posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class PostEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    @NotAudited
    private String description;

    @PrePersist
    void beforeSave(){

    }

    @PreUpdate
    void beforeUpdate(){

    }

    @PreRemove
    void beforeDelete(){

    }
}
