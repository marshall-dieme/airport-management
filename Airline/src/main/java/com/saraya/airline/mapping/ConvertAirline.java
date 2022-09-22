package com.saraya.airline.mapping;

import org.springframework.stereotype.Component;

import com.saraya.airline.dto.AirlineDTO;
import com.saraya.airline.model.Airline;

@Component
public class ConvertAirline {
	public Airline dtoTOENtity(AirlineDTO airlineDTO) {
		Airline air = new Airline();
		air.setIata(airlineDTO.getIata());
		air.setAirline_name(airlineDTO.getAirline_name());
		return air;
	}
	
	public AirlineDTO ENtityTOdto(Airline airline) {
		AirlineDTO airdto = new AirlineDTO();
		airdto.setAirline_id(airline.getAirline_id());
		airdto.setIata(airline.getIata());
		airdto.setAirline_name(airline.getAirline_name());
		return airdto;
	}
}
