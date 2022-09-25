package com.microservices.airplane.ServicesServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.microservices.airplane.ServicesServices.entity.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer>{
	
	List<Services> findByIdAir(String idAir);

}
