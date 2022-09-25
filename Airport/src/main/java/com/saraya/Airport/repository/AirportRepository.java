package com.saraya.Airport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airport.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{
    
}