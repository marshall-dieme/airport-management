package com.saraya.microservices.airline.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.microservices.airline.model.Airline;
import com.saraya.microservices.airline.model.AirlineDTO;
import com.saraya.microservices.airline.repository.AirlineRepository;


@Service
public class AirlineService {


	@Autowired
	private final AirlineRepository airlineRepository;


	public AirlineService(AirlineRepository airlineRepository) {
		super();
		this.airlineRepository = airlineRepository;
	}
	
	public List<Airline> getAllAirline(){
		return airlineRepository.findAll();
	}

	public Airline addAirline(AirlineDTO dto){
		Airline airline = new Airline();
		airline.setIata(dto.getIata());
		airline.setAirline_name(dto.getAirline_name());	
		return airlineRepository.save(airline);
	}


	public void deleteAirline(Long id){
		airlineRepository.deleteById(id);
		
	}

	public Airline updateAirline(AirlineDTO dto){
		Airline airline = new Airline();
		airline.setIata(dto.getIata());
		airline.setAirline_name(dto.getAirline_name());	
		return airlineRepository.save(airline);
	}

	

	
	
}
