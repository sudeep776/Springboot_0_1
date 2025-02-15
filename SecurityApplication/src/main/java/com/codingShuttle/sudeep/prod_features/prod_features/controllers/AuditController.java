package com.codingShuttle.sudeep.prod_features.prod_features.controllers;

import com.codingShuttle.sudeep.prod_features.prod_features.dto.PostDto;
import com.codingShuttle.sudeep.prod_features.prod_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/posts/{postId}")
    List<PostEntity> getRevisions(@PathVariable Long postId){
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions= auditReader.getRevisions(PostEntity.class,postId);
        return revisions.stream().map(revisionNumber->auditReader.find(PostEntity.class,postId,revisionNumber)).collect(Collectors.toList());
    }
}
