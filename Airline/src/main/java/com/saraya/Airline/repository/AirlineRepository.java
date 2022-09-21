package com.saraya.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airline.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline , Integer>{


	Airline findByAirline_name(String airline_name);

}
