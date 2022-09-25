package com.saraya.passenger.mapper;

import org.springframework.stereotype.Component;

import com.saraya.passenger.dto.PassengerDTO;
import com.saraya.passenger.model.Passengar;

@Component
public class ConvertPassenger {
	public Passengar toPassenger(PassengerDTO dto) {
		Passengar passengar = new Passengar();
		passengar.setFirstname(dto.getFirstname());
		passengar.setLastname(dto.getLastname());
		passengar.setPassport_no(dto.getPassport_no());
		return passengar;
	}
	
	public PassengerDTO toDTO(Passengar entity) {
		PassengerDTO dto = new PassengerDTO();
		dto.setPassenger_id(entity.getPassenger_id());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setPassport_no(entity.getPassport_no());
		return dto;
	}
}
