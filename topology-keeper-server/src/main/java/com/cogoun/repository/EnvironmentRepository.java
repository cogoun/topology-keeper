package com.cogoun.repository;

import com.cogoun.entity.EnvironmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<EnvironmentEntity, Long> {
}
