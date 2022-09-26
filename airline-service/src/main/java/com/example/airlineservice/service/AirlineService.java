package com.example.airlineservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.airlineservice.model.AirlineDTO;

@Service
public interface AirlineService {
	
	List<AirlineDTO> getAll();
	
	AirlineDTO getAilineById(Long id);
	
	AirlineDTO createAirline(AirlineDTO airlineDTO);
	
	AirlineDTO updateAirline(AirlineDTO airlineDTO, Long id);
	
	void deleteAirline(Long id);

}
