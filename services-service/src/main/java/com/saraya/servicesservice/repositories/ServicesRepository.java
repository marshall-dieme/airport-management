package com.saraya.servicesservice.repositories;

import com.saraya.servicesservice.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Long> {
}
