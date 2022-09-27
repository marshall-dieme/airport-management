package com.saraya.microservices.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.saraya.microservices.airline.model.Airline;





@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long>{	
	
}
