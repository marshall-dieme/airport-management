package com.saraya.parking.mapper;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.saraya.parking.bean.Parking;
import com.saraya.parking.dto.ParkingDTO;

@Component
public class Mapper {
	public Parking toParking(ParkingDTO dto) {
		Parking parking = new Parking();
		parking.setAmount(dto.getAmount());
		parking.setCar_no(dto.getCar_no());
		parking.setContact(dto.getContact());
		parking.setEmail(dto.getEmail());
		parking.setEntry_date(LocalDate.parse(dto.getEntry_date()));
		parking.setEntry_time(LocalTime.parse(dto.getEntry_time()));
		parking.setExit_date(LocalDate.parse(dto.getExit_date()));
		parking.setExit_time(LocalTime.parse(dto.getExit_time()));
		parking.setName(dto.getName());
		return parking;
	}
	
	public ParkingDTO toDTO(Parking parking) {
		ParkingDTO dto = new ParkingDTO();
		dto.setParking_id(parking.getParking_id());
		dto.setAmount(parking.getAmount());
		dto.setCar_no(parking.getCar_no());
		dto.setContact(parking.getContact());
		dto.setEmail(parking.getEmail());
		dto.setEntry_date(parking.getEntry_date().toString());
		dto.setEntry_time(parking.getEntry_time().toString());
		dto.setExit_date(parking.getExit_date().toString());
		dto.setExit_time(parking.getExit_time().toString());
		dto.setName(dto.getName());
		return dto;
	}
}
