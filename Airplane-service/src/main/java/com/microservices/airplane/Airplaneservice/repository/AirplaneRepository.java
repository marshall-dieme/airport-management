package com.microservices.airplane.Airplaneservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.microservices.airplane.Airplaneservice.entity.Airplane;


@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, String>{

	
	List<Airplane> findByIdairline(String idairline);
	
	
	Airplane findByCapacity(String capacity);
}
