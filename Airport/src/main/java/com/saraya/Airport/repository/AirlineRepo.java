package com.saraya.Airport.repository;

import com.saraya.Airport.entity.Airline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AirlineRepo extends JpaRepository<Airline, Long> {
    
}