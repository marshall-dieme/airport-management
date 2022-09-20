package com.example.servicesservice.repos;

import com.example.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {

   // Services findByName(String name);
}
