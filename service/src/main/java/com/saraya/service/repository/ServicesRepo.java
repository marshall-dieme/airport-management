package com.saraya.service.repository;

import com.saraya.service.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {
    @Query("SELECT s FROM Services  s WHERE s.services_name= ?1")
    Services getServiceByService_name(String name);
}