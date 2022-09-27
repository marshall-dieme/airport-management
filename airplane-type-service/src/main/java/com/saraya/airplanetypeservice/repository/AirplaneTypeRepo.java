package com.saraya.airplanetypeservice.repository;

import com.saraya.airplanetypeservice.bean.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Integer> {
    AirplaneType findByAirplaneTypeIdentifier(String identifier);
}
