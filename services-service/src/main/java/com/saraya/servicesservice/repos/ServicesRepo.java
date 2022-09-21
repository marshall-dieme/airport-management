package com.saraya.servicesservice.repos;

import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {

   // Services findByName(String name);




}
