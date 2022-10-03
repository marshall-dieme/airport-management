package com.saraya.servicesservice.repos;

import com.saraya.servicesservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Service_Repo extends JpaRepository<Service,Long> {
    //  @Query("select ag from Airport_Geo ag WHERE ag.airport_geo_id=?1" )
    @Query("select s.service_id from Service s WHERE s.serviceName=:serviceName" )

    Long getIdServices(String serviceName);

   List<Service>  findByAirportId(Long airportId);
}
