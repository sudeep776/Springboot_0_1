package com.codingShuttle.sudeep.prod_features.prod_features.repositories;

import com.codingShuttle.sudeep.prod_features.prod_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
