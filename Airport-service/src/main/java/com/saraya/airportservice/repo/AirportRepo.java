package com.saraya.airportservice.repo;

import com.saraya.airportservice.bean.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Integer> {
    Airport findByAirportId(int id);

}
