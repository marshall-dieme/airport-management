package com.saraya.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.passenger.model.Passengar;
@Repository
public interface PassengerRepository extends JpaRepository<Passengar, Long>{
	 
}
