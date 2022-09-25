package com.saraya.microservice.airlineservice.repo;

import com.saraya.microservice.airlineservice.bean.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
}
