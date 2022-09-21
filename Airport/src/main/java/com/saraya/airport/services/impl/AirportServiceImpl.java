package com.saraya.airport.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.airport.dto.AiportDTO;
import com.saraya.airport.entity.AirportEntity;
import com.saraya.airport.mapping.ConvertAirport;
import com.saraya.airport.repository.AirportRepo;
import com.saraya.airport.services.AirportService;
@Service
public class AirportServiceImpl implements AirportService{
	@Autowired
	private AirportRepo airportRepo;
	@Autowired
	private ConvertAirport convertAirport;
	@Override
	public AiportDTO createAirport(AiportDTO aiportDTO) {
		AirportEntity ae = convertAirport.dtoTOEntity(aiportDTO);
		airportRepo.save(ae);
		aiportDTO = convertAirport.EntityTOdto(ae);
		return aiportDTO;
	}

}
