package com.saraya.PassengerDetailsservice.mapper;

import com.saraya.PassengerDetailsservice.dto.PassengerDetailsDto;
import com.saraya.PassengerDetailsservice.enums.Gender;
import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public PassengerDetails mapToEntity(PassengerDetailsDto dto) {
        PassengerDetails details = new PassengerDetails();
        details.setPassenger_details_id(dto.getPassenger_details_id());
       /* details.setBirthdate(LocalDate.parse(dto.getBirthdate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));*/
        details.setSex(dto.getSex());
        details.setEmail(dto.getEmail());
        details.setCity(dto.getCity());
        details.setCountry(dto.getCountry());
        details.setStreet(dto.getStreet());
        details.setTelephone(dto.getTelephone());
        details.setZip(dto.getZip());

        return details;
    }

    public PassengerDetailsDto mapToDto(PassengerDetails details) {
        PassengerDetailsDto dto = new PassengerDetailsDto();
        dto.setPassenger_details_id(details.getPassenger_details_id());
       /* dto.setBirthdate(details.getBirthdate().toString());*/
        dto.setSex(details.getSex().toString());
        dto.setEmail(details.getEmail());
        dto.setCity(details.getCity());
        dto.setCountry(details.getCountry());
        dto.setStreet(details.getStreet());
        dto.setTelephone(details.getTelephone());
        dto.setZip(details.getZip());

        return dto;
    }
}
