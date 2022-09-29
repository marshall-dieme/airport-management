package com.regulus.rentalservice.services;

import com.regulus.rentalservice.dtos.RentalDto;
import com.regulus.rentalservice.models.Rental;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public RentalDto toDto(Rental parking){
        RentalDto dto = new RentalDto();
        dto.setRental_id(parking.getRental_id());
        dto.setName(parking.getName());
        dto.setEmail(parking.getEmail());
        dto.setContact(parking.getContact());
        dto.setLicence_no(parking.getLicence_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        dto.setPickup_date(parking.getPickup_date().format(formatter));
        dto.setPickup_time(parking.getPickup_time().format(formatter1));
        dto.setReturn_date(parking.getReturn_date().format(formatter));
        dto.setReturn_time(parking.getReturn_time().format(formatter1));
        dto.setCar_no(parking.getCar_no());
        dto.setAmount(parking.getAmount());
        return dto;
    }

    public Rental toEntity(RentalDto dto){
        Rental parking = new Rental();
        parking.setRental_id(dto.getRental_id());
        parking.setName(dto.getName());
        parking.setEmail(dto.getEmail());
        parking.setContact(dto.getContact());
        parking.setLicence_no(dto.getLicence_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        parking.setPickup_date(LocalDate.parse(dto.getPickup_date(), formatter));
        parking.setPickup_time(LocalTime.parse(dto.getPickup_time(), formatter1));
        parking.setReturn_date(LocalDate.parse(dto.getReturn_date(), formatter));
        parking.setReturn_time(LocalTime.parse(dto.getReturn_time(), formatter1));
        parking.setCar_no(dto.getCar_no());
        parking.setAmount(dto.getAmount());
        return parking;
    }

}
