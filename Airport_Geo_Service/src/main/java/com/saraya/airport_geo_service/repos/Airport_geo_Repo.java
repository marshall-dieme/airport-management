package com.saraya.airport_geo_service.repos;

import com.saraya.airport_geo_service.model.Airport_Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Airport_geo_Repo extends JpaRepository<Airport_Geo,Long> {
    //  @Query("select ag from Airport_Geo ag WHERE ag.airport_geo_id=?1" )
    @Query("select ag from Airport_Geo ag WHERE ag.airport_geo_id=:airport_geo_id" )
    Airport_Geo retrieveById(Long airport_geo_id);

    //Airport_Geo findById(Long airport_geo_id);
}
