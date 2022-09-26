package com.example.airplaneservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.airplaneservice.model.AirplaneDTO;


@Service
public interface AirplaneService {

	List<AirplaneDTO> getAllAirplane();
	
	AirplaneDTO getAirplaneById(Long id);
	
	AirplaneDTO createAirplane(AirplaneDTO airplaneDTO);
	
	AirplaneDTO updateAiplane(AirplaneDTO airplaneDTO, Long id);
	
	void deleteAirplane(Long id);
	
}
