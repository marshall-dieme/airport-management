package com.saraya.airplanetypeservice.repository;

import com.saraya.airplanetypeservice.model.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType , Integer> {
    AirplaneType findByAirplaneTypeIdentifier(String airplaneTypeIdentifier);
}
