package com.microservices.airline.Passager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airline.Passager.entity.Passager;

@Repository
public interface PassagerRepository extends JpaRepository<Passager, String>{
	
	Passager  findByPassportno(String passportno);

}
