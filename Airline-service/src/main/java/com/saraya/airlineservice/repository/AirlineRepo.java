package com.saraya.airlineservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.airlineservice.model.Airline;


public interface AirlineRepo  extends JpaRepository<Airline, Long>{
	

}
