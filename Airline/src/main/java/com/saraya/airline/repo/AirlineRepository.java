package com.saraya.airline.repo;

import com.saraya.airline.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
      Airline findById(long airline_id);
}
