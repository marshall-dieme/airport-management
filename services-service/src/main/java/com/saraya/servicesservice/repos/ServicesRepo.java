package com.saraya.servicesservice.repos;

import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {

   // Services findByName(String name);
   @Query("select s.serviceId from Services s where s.serviceName=:serviceName")
   Long getServiceId(String serviceName);

  List<Services> findByIdAirport(Long idAirport);



}
