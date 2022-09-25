package com.saraya.flight.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.saraya.flight.bean.Flight;
import com.saraya.flight.dto.FlightDTO;

@Component
public class ConvertFlight {
	public Flight toFlight(FlightDTO dto) {
		Flight flight = new Flight();
		flight.setArrival_date(LocalDate.parse(dto.getArrival_date()));
		flight.setDeparture_date(LocalDate.parse(dto.getDeparture_date()));
		flight.setFlight_no(dto.getFlight_no());
		flight.setFrom(dto.getFrom());
		flight.setTo(dto.getTo());
		return null;
	}
	
	public FlightDTO toDTO(Flight flight) {
		FlightDTO dto = new FlightDTO();
		dto.setArrival_date(flight.getArrival_date().toString());
		dto.setDeparture_date(flight.getDeparture_date().toString());
		dto.setFlight_no(flight.getFlight_no());
		dto.setFrom(flight.getFrom());
		dto.setTo(flight.getTo());
		return dto;
	}
}
