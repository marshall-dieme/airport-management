package com.saraya.Services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Services.model.Services_airport;


@Repository
public interface ServicesRepo extends JpaRepository<Services_airport , Integer>{
	Services_airport findByServices_name(String services_name);
	void deleteByService_name(String services_name);

}
