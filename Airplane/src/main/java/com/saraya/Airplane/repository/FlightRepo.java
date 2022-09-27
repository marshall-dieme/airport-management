package com.saraya.Airplane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airplane.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    
}