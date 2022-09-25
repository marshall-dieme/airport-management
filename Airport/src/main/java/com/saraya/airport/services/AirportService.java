package com.saraya.airport.services;

import java.util.List;

import com.saraya.airport.dto.AiportDTO;
import com.saraya.airport.entity.AirportEntity;

public interface AirportService {
	//AiportDTO createAirport(AiportDTO aiportDTO);
	AiportDTO showAirport(Long aiportId);
	List<AiportDTO> getAllAirport();
	AiportDTO updateAirport(AiportDTO aiportDTO, Long airportId);
	void deleteAirport(Long airportId);
	AiportDTO create (AiportDTO aiportDTO);
}
