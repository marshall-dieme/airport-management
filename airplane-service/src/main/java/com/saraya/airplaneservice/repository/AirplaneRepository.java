package com.saraya.airplaneservice.repository;

import com.saraya.airplaneservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane , Integer> {
    Airplane findByCapacity(String capacity);
}
