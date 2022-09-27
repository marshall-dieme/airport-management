package com.saraya.microservices.airplane.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.microservices.airplane.model.Airplane;
import com.saraya.microservices.airplane.model.AirplaneDTO;
import com.saraya.microservices.airplane.repository.AirplaneRepository;


@Service
public class AirplaneService {


	@Autowired
	private final AirplaneRepository airplaneRepository;


	public AirplaneService(AirplaneRepository airplaneRepository) {
		super();
		this.airplaneRepository = airplaneRepository;
	}
	
	public List<Airplane> getAllAirplane(){
		return airplaneRepository.findAll();
	}

	public Airplane addAirplane(AirplaneDTO dto){
		Airplane airplane = new Airplane();
		airplane.setCapacity(dto.getCapacity());	
		return airplaneRepository.save(airplane);
	}


	public void deleteAirplane(Long id){
		airplaneRepository.deleteById(id);
		
	}

	public Airplane updateAirplane(AirplaneDTO dto){
		Airplane airplane = new Airplane();
		airplane.setCapacity(dto.getCapacity());	
		return airplaneRepository.save(airplane);
	}

	

	
	
}
