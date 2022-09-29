package com.regulus.passengerservice.services;

import com.regulus.passengerservice.dtos.PassengerDto;
import com.regulus.passengerservice.models.Passenger;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public PassengerDto toDto(Passenger passenger){
        PassengerDto dto = new PassengerDto();
        dto.setPassenger_id(passenger.getPassenger_id());
        dto.setPassport_no(passenger.getPassport_no());
        dto.setFirstName(passenger.getFirstName());
        dto.setLastName(passenger.getLastName());
        dto.setBooking_id(passenger.getBooking_id());
        return dto;
    }

    public Passenger toEntity(PassengerDto dto){
        Passenger passenger = new Passenger();
        passenger.setPassenger_id(dto.getPassenger_id());
        passenger.setPassport_no(dto.getPassport_no());
        passenger.setFirstName(dto.getFirstName());
        passenger.setLastName(dto.getLastName());
        passenger.setBooking_id(dto.getBooking_id());
        return passenger;
    }

}
