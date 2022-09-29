package com.saraya.microserviceservices.repositories;

import com.saraya.microserviceservices.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Long> {
}
