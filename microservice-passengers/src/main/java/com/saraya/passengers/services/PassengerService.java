package com.saraya.passengers.services;

import com.saraya.passengers.exceptions.ResourceNotFoundException;
import com.saraya.passengers.models.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PassengerService {

    Passenger add(Passenger passenger);
    Passenger update(Passenger passenger);
    Passenger getPassenger(Long passenger_id) throws ResourceNotFoundException;
    Page<Passenger> getPassengers(Pageable pageable);
    void delete(Long passenger_id) throws ResourceNotFoundException;
    boolean existPassenger(Long passenger_id);

}
