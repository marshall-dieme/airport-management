package com.saraya.airportservice.repo;

import com.saraya.airportservice.bean.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
    Airport findByName(String name);
}
