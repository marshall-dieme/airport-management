package com.saraya.Services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Services.entity.Services;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {
    
}