package com.airportmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airportmanager.dto.AirplaneToAirlineDto;
import com.airportmanager.dto.AirplaneToAirplane_Type;
import com.airportmanager.dto.AirplaneToFlightDto;
import com.airportmanager.model.Airplane;
import com.airportmanager.repository.AirplaneRepository;

@Service
public class AirplaneService {
	@Autowired
	//relationship AirplaneToAirlineDto
	private AirplaneRepository airplaneRepository;
	public List<AirplaneToAirlineDto>getAllAirplaneToAirlineDto(){
		return airplaneRepository.findAll()
				.stream()
				.map(this::airplaneToairline)
				.collect(Collectors.toList());
	}
	private AirplaneToAirlineDto airplaneToairline(Airplane airplane) {
		AirplaneToAirlineDto APAL = new AirplaneToAirlineDto();
		APAL.setCapacity(airplane.getCapacity());
		return APAL;
		
	}
	
	//relationship AirplaneToFlightDto
	
	public List<AirplaneToFlightDto>getAllAirplaneToFlightDto(){
		return airplaneRepository.findAll()
				.stream()
				.map(this::airplaneToFlight)
				.collect(Collectors.toList());
	}
	private AirplaneToFlightDto airplaneToFlight(Airplane airplane) {
		AirplaneToFlightDto APF = new AirplaneToFlightDto();
		APF.setCapacity(airplane.getCapacity());
		
		return APF;
		
	}
	//relationship AirplaneToAirplane_Type
	public List<AirplaneToAirplane_Type>getAirplaneToAirplane_Type(){
		return airplaneRepository.findAll()
				.stream()
				.map(this::airplaneToAirplane_Type)
				.collect(Collectors.toList());
	}
	private AirplaneToAirplane_Type  airplaneToAirplane_Type(Airplane airplane) {
		AirplaneToAirplane_Type APAP_T = new AirplaneToAirplane_Type();
		APAP_T.setCapacity(airplane.getCapacity());
		return APAP_T;
	}

}
