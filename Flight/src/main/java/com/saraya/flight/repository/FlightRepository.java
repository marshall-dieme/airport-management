package com.saraya.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.flight.bean.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
