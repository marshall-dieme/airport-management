package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

}
