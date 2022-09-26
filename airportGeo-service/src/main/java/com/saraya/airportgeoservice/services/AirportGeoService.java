package com.saraya.airportgeoservice.services;

import com.saraya.airportgeoservice.exceptions.ResourceNotFoundException;
import com.saraya.airportgeoservice.models.AirportGeo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirportGeoService {

    AirportGeo add(AirportGeo airportGeo);
    AirportGeo update(AirportGeo airportGeo);
    AirportGeo getAirportGeo(Long airportGeo_id) throws ResourceNotFoundException;
    Page<AirportGeo> getAirportGeos(Pageable pageable);
    void delete(Long airportGeo_id) throws ResourceNotFoundException;
    boolean existAirportGeo(Long airportGeo_id);

}
