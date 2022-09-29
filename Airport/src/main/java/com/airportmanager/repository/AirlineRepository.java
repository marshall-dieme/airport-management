package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline , Long> {

}
