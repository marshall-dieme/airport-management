package com.saraya.Airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saraya.Airport.entity.Services;


@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {
    
}