package com.example.airplaneservice.repo;

import com.example.airplaneservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepo extends JpaRepository<Airplane, Long> {
}
