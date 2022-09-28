package com.airport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.entities.Airline;
@Repository
public interface Airline_Repository extends JpaRepository<Airline, Long>{

}
