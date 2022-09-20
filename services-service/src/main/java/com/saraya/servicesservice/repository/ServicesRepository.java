package com.saraya.servicesservice.repository;

import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services , Integer> {
    Services findByServicesName(String servicesName);
}
