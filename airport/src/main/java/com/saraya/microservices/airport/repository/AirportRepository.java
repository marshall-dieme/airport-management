package com.saraya.microservices.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.saraya.microservices.airport.model.Airport;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{	
	
}
