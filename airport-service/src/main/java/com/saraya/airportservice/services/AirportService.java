package com.saraya.airportservice.services;

import com.saraya.airportservice.exceptions.ResourceNotFoundException;
import com.saraya.airportservice.models.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirportService {

   Airport add(Airport airport);
   Airport update(Airport airport);
   Airport getAirport(Long airport_id) throws ResourceNotFoundException;
    Page<Airport> getAirports(Pageable pageable);
    void delete(Long airport_id) throws ResourceNotFoundException;
    boolean existAirport(Long airport_id);

}
