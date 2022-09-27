package com.saraya.Airplane_Type.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airplane_Type.entity.AirplaneType;

@Repository
public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Long>{
    
}