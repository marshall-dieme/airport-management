package com.saraya.servicesservice.repository;
import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

    @Query("select a.services_id from Services a where a.services_name=:services_name")
    Long getIdServices(String services_name);
    
}
