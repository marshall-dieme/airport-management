package com.saraya.microservices.airport.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.microservices.airport.model.Airport;
import com.saraya.microservices.airport.model.AirportDTO;
import com.saraya.microservices.airport.repository.AirportRepository;


@Service
public class AirportService {


	@Autowired
	private final AirportRepository airportRepository;


	public AirportService(AirportRepository airportRepository) {
		super();
		this.airportRepository = airportRepository;
	}
	
	public List<Airport> getAllAirport(){
		return airportRepository.findAll();
	}

	public Airport addAirport(AirportDTO dto){
		Airport airport = new Airport();
		airport.setIata(dto.getIata());
		airport.setIcao(dto.getIcao());
		airport.setAirport_name(dto.getAirport_name());	
		return airportRepository.save(airport);
	}


	public void deleteAirport(Long id){
		airportRepository.deleteById(id);
		
	}

	public Airport updateAirport(Airport aip){
		return airportRepository.save(aip);
	}

	

	
	
}
