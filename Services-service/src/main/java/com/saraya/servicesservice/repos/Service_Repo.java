package com.saraya.servicesservice.repos;

import com.saraya.servicesservice.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Service_Repo extends JpaRepository<Services,Long> {
    //  @Query("select ag from Airport_Geo ag WHERE ag.airport_geo_id=?1" )
    @Query("select s from Services s WHERE s.services_name=:services_name" )

    Long getIdServices(String services_name);

//    Services findByName(String services_name);
}
