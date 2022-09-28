package com.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.entities.Airport;

@Repository
public interface Airport_Repository extends JpaRepository<Airport, Long> {

}
