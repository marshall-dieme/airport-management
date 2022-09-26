package com.saraya.airlineservice.services;

import com.saraya.airlineservice.exceptions.ResourceNotFoundException;
import com.saraya.airlineservice.models.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirlineService {

    Airline add(Airline airline);
    Airline update(Airline airline);
    Airline getAirline(Long airline_id) throws ResourceNotFoundException;
    Page<Airline> getAirlines(Pageable pageable);
    void delete(Long airline_id) throws ResourceNotFoundException;
    boolean existAirline(Long airline_id);

}
