package com.spring.serviceemplrelation.repository;

import com.spring.serviceemplrelation.bean.ServiceEmplRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends JpaRepository<ServiceEmplRelation, Integer> {
}
