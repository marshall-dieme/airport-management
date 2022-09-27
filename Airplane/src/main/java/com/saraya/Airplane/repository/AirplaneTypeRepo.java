package com.saraya.Airplane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.Airplane.entity.AirplaneType;

public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Long> {
    
}