package com.saraya.passengerservice.mapper;

import com.saraya.passengerservice.bean.Passenger;
import com.saraya.passengerservice.dto.PassengerDto;

public class PassengerMapper {
    public Passenger toEntity(PassengerDto dto) {
        Passenger passenger = new Passenger();
        passenger.setFirstname(dto.getFirstname());
        passenger.setLastname(dto.getLastname());
        passenger.setPassportNo(dto.getPassportNo());
        return passenger;
    }
}
