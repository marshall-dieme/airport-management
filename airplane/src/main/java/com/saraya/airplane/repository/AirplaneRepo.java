package com.saraya.airplane.repository;

import com.saraya.airplane.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Long> {

    Airplane findAirplaneByCapacity(int capacity);
}
