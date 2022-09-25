package com.saraya.parking.mapper;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.saraya.parking.dto.RenaltsDTO;
import com.saraya.parking.model.Rentals;

@Component
public class ConvertRentals {
	public Rentals toRentals(RenaltsDTO dto) {
		Rentals rentals = new Rentals();
		rentals.setAmount(dto.getAmount());
		rentals.setCar_no(dto.getCar_no());
		rentals.setContact(dto.getContact());
		rentals.setEmail(dto.getEmail());
		rentals.setLicence_no(dto.getLicence_no());
		rentals.setName(dto.getName());
		rentals.setPickup_date(LocalDate.parse(dto.getPickup_date()));
		rentals.setPickup_time(LocalTime.parse(dto.getPickup_time()));
		rentals.setReturn_date(LocalDate.parse(dto.getReturn_date()));
		rentals.setReturn_time(LocalTime.parse(dto.getReturn_time()));
		return null;
	}
	
	
	public RenaltsDTO toDTO(Rentals rentals) {
		RenaltsDTO dto = new RenaltsDTO();
		dto.setAmount(rentals.getAmount());
		dto.setCar_no(rentals.getCar_no());
		dto.setContact(rentals.getContact());
		dto.setEmail(rentals.getEmail());
		dto.setLicence_no(rentals.getLicence_no());
		dto.setName(rentals.getName());
		dto.setPickup_date(rentals.getPickup_date().toString());
		dto.setPickup_time(rentals.getPickup_time().toString());
		dto.setReturn_date(rentals.getReturn_date().toString());
		dto.setReturn_time(rentals.getReturn_time().toString());
		return null;
	}
}
