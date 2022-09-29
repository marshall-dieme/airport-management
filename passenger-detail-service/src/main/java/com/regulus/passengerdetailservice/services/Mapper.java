package com.regulus.passengerdetailservice.services;

import com.regulus.passengerdetailservice.dtos.PassengerDetailsDto;
import com.regulus.passengerdetailservice.models.PassengerDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public PassengerDetailsDto toDto(PassengerDetails details){
        PassengerDetailsDto dto = new PassengerDetailsDto();
        dto.setPassenger_details_id(details.getPassenger_details_id());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dto.setBirthDate(details.getBirthDate().format(formatter));
        dto.setSex(details.getSex());
        dto.setStreet(details.getStreet());
        dto.setCity(details.getCity());
        dto.setZip(details.getZip());
        dto.setContry(details.getContry());
        dto.setEmail(details.getEmail());
        dto.setTelephone(details.getTelephone());
        return dto;
    }

    public PassengerDetails toEntity(PassengerDetailsDto dto){
        PassengerDetails details = new PassengerDetails();
        details.setPassenger_details_id(dto.getPassenger_details_id());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        details.setBirthDate(LocalDate.parse(dto.getBirthDate(), formatter));
        details.setSex(dto.getSex());
        details.setStreet(dto.getStreet());
        details.setCity(dto.getCity());
        details.setZip(dto.getZip());
        details.setContry(dto.getContry());
        details.setEmail(dto.getEmail());
        details.setTelephone(dto.getTelephone());
        return details;
    }

}
