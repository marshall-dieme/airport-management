package com.saraya.airportservice.repo;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.bean.AirportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
    Optional<Airport> findByName(String name);
}
