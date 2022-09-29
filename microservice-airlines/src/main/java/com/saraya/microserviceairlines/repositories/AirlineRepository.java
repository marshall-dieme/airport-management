package com.saraya.microserviceairlines.repositories;

import com.saraya.microserviceairlines.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {
}
