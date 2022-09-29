package com.regulus.flighttimetablerelation.repositories;

import com.regulus.flighttimetablerelation.models.FlightTimeTableRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLightTimeTableRepository extends JpaRepository<FlightTimeTableRelation, Integer> {
}
