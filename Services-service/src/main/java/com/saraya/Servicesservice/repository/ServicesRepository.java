package com.saraya.Servicesservice.repository;

import com.saraya.Servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    @Query("SELECT s FROM Services  s WHERE s.services_name= ?1")
    Services getServiceByService_name(String name);
}
