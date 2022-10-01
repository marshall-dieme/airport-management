package com.saraya.microserviceflights.services;

import com.saraya.microserviceflights.exceptions.ResourceNotFoundException;
import com.saraya.microserviceflights.models.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FlightService {

    Flight add(Flight flight);
    Flight update(Flight flight);
    Flight getFlight(Long flight_id) throws ResourceNotFoundException;
    Page<Flight> getFlights(Pageable pageable);
    void delete(Long flight_id) throws ResourceNotFoundException;
    boolean existFlight(Long flight_id);

}
