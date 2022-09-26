package com.example.airplaneservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airplaneservice.model.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long>{

}
