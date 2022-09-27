package com.saraya.Airplane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.Airplane.entity.Airplane;

public interface AirplaneRepo extends JpaRepository<Airplane, Long> {
    
}