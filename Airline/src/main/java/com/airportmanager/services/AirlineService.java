package com.airportmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airportmanager.dto.AirlineToAirplaneDto;
import com.airportmanager.dto.AirlineToAirportDto;
import com.airportmanager.model.Airline;
import com.airportmanager.repository.AirlineRepository;

@Service
public class AirlineService {
	
@Autowired
private AirlineRepository airlineRepository;
	public List<AirlineToAirplaneDto>getAllAirlineToAirplaneDto(){
		return airlineRepository.findAll()
				.stream()
				.map(this::airlineToairplane)
				.collect(Collectors.toList());
		
	}
		private AirlineToAirplaneDto airlineToairplane(Airline airline) {
			AirlineToAirplaneDto ALAP = new AirlineToAirplaneDto();
			ALAP.setAirline_name(airline.getAirline_name());
			ALAP.setIata(airline.getIata());
			return ALAP;
			
		}
		public List<AirlineToAirportDto>getAllAirlineToAirportDto(){
			return airlineRepository.findAll()
					.stream()
					.map(this::airlineToairport)
					.collect(Collectors.toList());
			
		}
		private AirlineToAirportDto airlineToairport(Airline airline) {
			AirlineToAirportDto ALAPort = new AirlineToAirportDto();
			ALAPort.setIata(airline.getIata());
			ALAPort.setAirline_name(airline.getAirline_name());
			return ALAPort;
			
		}
		
	

}
