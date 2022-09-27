package com.saraya.microservices.airplane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.saraya.microservices.airplane.model.Airplane;


@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long>{	
	
}
