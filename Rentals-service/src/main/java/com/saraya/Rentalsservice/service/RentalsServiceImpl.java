package com.saraya.Rentalsservice.service;

import com.saraya.Rentalsservice.bean.Passenger;
import com.saraya.Rentalsservice.dto.RentalsDto;
import com.saraya.Rentalsservice.model.Rentals;
import com.saraya.Rentalsservice.proxies.PassengerProxy;
import com.saraya.Rentalsservice.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalsServiceImpl implements RentalsService{

    private static int number = 1;
    private final RentalRepository rentalRepository;
    private final PassengerProxy passengerProxy;

    private final ModelMapper modelMapper;

    @Override
    public List<RentalsDto> getAllRentals() {
        List<RentalsDto> dtos = new ArrayList<>();
        for (Rentals rental: rentalRepository.findAll()) {
            RentalsDto dto  = modelMapper.map(rental, RentalsDto.class);
            dto.setPassport_no(passengerProxy.getPassenger(rental.getPassenger_id()).getPassport_no());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public RentalsDto getRentalById(Long rental_id) {
        RentalsDto dto = new RentalsDto();
        Rentals rentals = rentalRepository.findById(rental_id).orElse(null);
        if (rentals != null) {
            dto  = modelMapper.map(rentals, RentalsDto.class);
            dto.setPassport_no(passengerProxy.getPassenger(rentals.getPassenger_id()).getPassport_no());
        }
        return dto;
    }

    @Override
    public Rentals saveRental(RentalsDto dto) {
        Rentals rentals =  getRentals(dto);
        rentals.setCar_no(generateCar_No());
        return rentalRepository.save(rentals);
    }



    @Override
    public Rentals updateRental(RentalsDto dto) {
        return rentalRepository.save(getRentals(dto));
    }

    @Override
    public void deleteRental(Long rental_id) {
        rentalRepository.deleteById(rental_id);
    }

    private Rentals getRentals(RentalsDto dto) {
        Rentals rental = modelMapper.map(dto, Rentals.class);
        Passenger passenger = passengerProxy.getPassengerByPassenger_no(dto.getPassport_no());
        rental.setPassenger_id(passenger.getPassenger_id());
        return rental;
    }

    /************** Generator Car_no ************/
    private String generateCar_No() {
        return "Car_No-" + number++;
    }

}
