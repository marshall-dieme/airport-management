package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport ,Long> {

}
