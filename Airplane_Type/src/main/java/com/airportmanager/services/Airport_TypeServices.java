package com.airportmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airportmanager.Dto.Airport_TypeToAirplaneDto;

import com.airportmanager.exception.ResourceNotFindException;
import com.airportmanager.model.Airplane_Type;

import com.airportmanager.repository.Airplane_TypeRepository;

@Service
public class Airport_TypeServices {
	@Autowired
	private Airplane_TypeRepository airplanetypeRepo;
	
	//create airport_geo
	public Airplane_Type CreateAirplane_Type(Airplane_Type airplaneType) {
		return airplanetypeRepo.save(airplaneType);
		
	}
	//find
	public List<Airplane_Type>findAllAirplaneType(){
		return airplanetypeRepo.findAll();	
	}
	//Update airport_geo
	public Airplane_Type UpdateAirplane_Type(Airplane_Type airplaneType) {
		return airplanetypeRepo.save(airplaneType);	
		
	}
	//find service by id
	public Airplane_Type findAirplaneTypeById(Long id) {
		return airplanetypeRepo.findById(id)
		.orElseThrow(()->new ResourceNotFindException("Service by id"+id+"Was not Found"));
	}

	//delete airport
	public void DeleteAirplane_Type(Long id) {
		airplanetypeRepo.deleteById(id);
	}

	//RelationShip Service to Airport
	public List<Airport_TypeToAirplaneDto>getAllAirplane_TypeToAirport(){
		return  airplanetypeRepo .findAll()
				.stream()
				.map(this::airplanetypeToairplane)
				.collect(Collectors.toList());
	}
	
	private Airport_TypeToAirplaneDto  airplanetypeToairplane(Airplane_Type airplaneType) {
		Airport_TypeToAirplaneDto APT = new Airport_TypeToAirplaneDto();
		APT.setAirplane_Type_identifier(airplaneType.getAirplane_Type_identifier());
		APT.setDescription(airplaneType.getDescription());
		return APT;
		
	}

}
