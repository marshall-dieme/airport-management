package com.saraya.microserviceairports.services;

import com.saraya.microserviceairports.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairports.models.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirportService {

   Airport add(Airport airport) throws ResourceNotFoundException;
   Airport update(Airport airport) throws ResourceNotFoundException;
   Airport getAirport(Long airport_id) throws ResourceNotFoundException;
    Page<Airport> getAirports(Pageable pageable);
    void delete(Long airport_id) throws ResourceNotFoundException;
    boolean existAirport(Long airport_id);

}
