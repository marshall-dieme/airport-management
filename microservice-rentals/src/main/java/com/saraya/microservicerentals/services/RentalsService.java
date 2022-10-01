package com.saraya.microservicerentals.services;

import com.saraya.microservicerentals.exceptions.ResourceNotFoundException;
import com.saraya.microservicerentals.models.Rentals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RentalsService {

    Rentals add(Rentals rentals);
    Rentals update(Rentals rentals);
    Rentals getRentals(Long rental_id) throws ResourceNotFoundException;
    Page<Rentals> getRentalss(Pageable pageable);
    void delete(Long rentals_id) throws ResourceNotFoundException;
    boolean existRentals(Long rental_id);

}
