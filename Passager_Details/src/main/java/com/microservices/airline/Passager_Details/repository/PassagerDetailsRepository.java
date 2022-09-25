package com.microservices.airline.Passager_Details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airline.Passager_Details.entity.PassagerDetails;

@Repository
public interface PassagerDetailsRepository extends JpaRepository<PassagerDetails, String>{

	PassagerDetails findByIdpass(String idpass);
	
	
	
	
}
