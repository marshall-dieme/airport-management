package com.microservices.airplane.Services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.Services.entity.Services;


@Repository
public interface ServiceRepository extends JpaRepository<Services, String>{

}
