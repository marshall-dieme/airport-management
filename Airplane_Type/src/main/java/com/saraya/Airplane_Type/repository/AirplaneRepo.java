package com.saraya.Airplane_Type.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airplane_Type.entity.Airplane;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Long>{
    
}