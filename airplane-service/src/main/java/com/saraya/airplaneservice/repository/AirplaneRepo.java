package com.saraya.airplaneservice.repository;

import com.saraya.airplaneservice.bean.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Integer> {
    Airplane getByCapacity(int capacity);
}
