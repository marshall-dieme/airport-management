package com.saraya.airlineservice.reository;

import com.saraya.airlineservice.bean.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
    Airline getAirlineByAirlineName(String name);
}
