package com.saraya.airplaneservice.repositories;

import com.saraya.airplaneservice.models.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {
}
