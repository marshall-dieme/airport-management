package com.airportmanager.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.airportmanager.Dto.AirportToAirlineDto;
import com.airportmanager.Dto.AirportToAirport_Geo;
import com.airportmanager.Dto.AirportToServices;

import com.airportmanager.exception.ResourceNotFindException;
import com.airportmanager.model.Airport;
import com.airportmanager.repository.AirportRepository;


@Service
public class AirportServices {
	
	@Autowired
	private  AirportRepository  airportRepo;
//	@Autowired
//	private  AirportServices airportServices ;
//	
	//create airport
	public Airport CreateAirport(Airport airport) {
		airport.setAirport_name(UUID.randomUUID().toString());
		return airportRepo.save(airport);
	}

	
	public List<Airport>findAllAirports(){
		return airportRepo.findAll();
	}
	//Update airport
	public Airport UpdateAirport(Airport airport) {
		return airportRepo.save(airport);
		
	}
	//find airport by id
	public Airport  findAirportById(Long id) {
	return airportRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFindException("Airport by id"+id+"Was not Found"));
		
	}
	//delete airport
	public void deleteAirport(Long id) {
		airportRepo.deleteById(id);
	}
//	
//	//get All AirlineToAirplane
//	@GetMapping("/airportToairline")
//	public List<AirportToAirlineDto> getAllAirportToAirline(){
//		return airportServices.getAllAirportToAirlineDto();
//	}
//	
//	//get All AirlineToAirport_Geo
//	@GetMapping("/airportToairline")
//	public List<AirportToAirport_Geo>getAllAirportToairport_Geo(){
//		return airportServices.getAllAirportToAirport_Geo();
//	}
//	
//	//get All AirlineToServices
//	@GetMapping("/airportToservices")
//	public List<AirportToServices>getAllAirportToservices(){
//		return airportServices.getAllAirportToServices();
//	}
//	
//	
	
	
	
	
	
	
	//RelationShip Airport to Airline
	
	
	public List<AirportToAirlineDto>getAllAirportToAirlineDto(){
		return airportRepo.findAll()
				.stream()
				.map(this::airportToairline)
				.collect(Collectors.toList());
	}
	
	private AirportToAirlineDto airportToairline(Airport airport) {
		AirportToAirlineDto APAL = new AirportToAirlineDto();
		APAL.setAirline_name(airport.getAirport_name());
		APAL.setAirport_name(airport.getAirport_name());
		APAL.setIata(airport.getIata());
		APAL.setIcao(airport.getIcao());
		return APAL;
		
	}
	//RelationShip Airport to Airport_Geo
	public List<AirportToAirport_Geo>getAllAirportToAirport_Geo(){
		return airportRepo.findAll()
				.stream()
				.map(this::airportToairportGeo)
				.collect(Collectors.toList());
	}
	private AirportToAirport_Geo  airportToairportGeo(Airport airport){
		AirportToAirport_Geo APAPG = new AirportToAirport_Geo();
		APAPG.setAirport_name(airport.getAirport_name());
		APAPG.setIata(airport.getIata());
		return APAPG;
		
	}
	//RelationShip Airport to Service
	public List<AirportToServices>getAllAirportToServices(){
		return airportRepo.findAll()
				.stream()
				.map(this::airportToservices)
				.collect(Collectors.toList());
	}
	private AirportToServices airportToservices(Airport airport) {
		AirportToServices APS = new  AirportToServices();
		APS.setAirport_name(airport.getAirport_name());
		APS.setIcao(airport.getIcao());
		return APS;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
