package com.saraya.Rentalsservice.service;

import com.saraya.Rentalsservice.dto.RentalsDto;
import com.saraya.Rentalsservice.model.Rentals;

import java.util.List;

public interface RentalsService {

    List<RentalsDto> getAllRentals();

    RentalsDto getRentalById(Long rental_id);

    Rentals saveRental(RentalsDto dto);

    Rentals updateRental(RentalsDto dto);

    void deleteRental(Long rental_id);


}
