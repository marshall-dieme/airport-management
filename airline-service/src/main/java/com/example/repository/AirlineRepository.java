package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airlineservice.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
