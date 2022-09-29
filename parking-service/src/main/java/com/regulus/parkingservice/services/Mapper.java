package com.regulus.parkingservice.services;

import com.regulus.parkingservice.dtos.ParkingDto;
import com.regulus.parkingservice.models.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public ParkingDto toDto(Parking parking){
        ParkingDto dto = new ParkingDto();
        dto.setParking_id(parking.getParking_id());
        dto.setName(parking.getName());
        dto.setEmail(parking.getEmail());
        dto.setContact(parking.getContact());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        dto.setEntry_date(parking.getEntry_date().format(formatter));
        dto.setEntry_time(parking.getEntry_time().format(formatter1));
        dto.setExit_date(parking.getExit_date().format(formatter));
        dto.setExit_time(parking.getExit_time().format(formatter1));
        dto.setCar_no(parking.getCar_no());
        dto.setAmount(parking.getAmount());
        return dto;
    }

    public Parking toEntity(ParkingDto dto){
        Parking parking = new Parking();
        parking.setParking_id(dto.getParking_id());
        parking.setName(dto.getName());
        parking.setEmail(dto.getEmail());
        parking.setContact(dto.getContact());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        parking.setEntry_date(LocalDate.parse(dto.getEntry_date(), formatter));
        parking.setEntry_time(LocalTime.parse(dto.getEntry_time(), formatter1));
        parking.setExit_date(LocalDate.parse(dto.getExit_date(), formatter));
        parking.setExit_time(LocalTime.parse(dto.getExit_time(), formatter1));
        parking.setCar_no(dto.getCar_no());
        parking.setAmount(dto.getAmount());
        return parking;
    }

}
