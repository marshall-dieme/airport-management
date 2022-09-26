package com.vlm.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.services.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

}
