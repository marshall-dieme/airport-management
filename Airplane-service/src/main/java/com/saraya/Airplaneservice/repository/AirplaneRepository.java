package com.saraya.Airplaneservice.repository;

import com.saraya.Airplaneservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    Airplane findAirplaneByCapacity(int capacity);
}
