package com.saraya.passengerdetails.mapper;

import com.saraya.passengerdetails.bean.PassengerDetails;
import com.saraya.passengerdetails.dto.PassengerDetailsDto;

public class PassengerDetailsMapper {
    public PassengerDetails toEntity(PassengerDetailsDto dto) {
        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setEmail(dto.getEmail());
        passengerDetails.setTelephone(dto.getTelephone());
        return passengerDetails;
    }
}
