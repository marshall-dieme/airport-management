package com.vlm.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.airline.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

	List<Airline> findByIata(String iata);

}
