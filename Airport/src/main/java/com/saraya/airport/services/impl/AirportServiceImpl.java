package com.saraya.airport.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Override
	public AiportDTO showAirport(Long airportId) {
		Optional<AirportEntity> ae = airportRepo.findById(airportId);
		AiportDTO ad = null;
		if(ae.isPresent()) {
			 ad = convertAirport.EntityTOdto(ae.get());
		}
		else {
			throw new RuntimeException("Did not find Airport id - " + airportId);
		}
		
		return ad;
	}
	@Override
	public List<AiportDTO> getAllAirport() {
		List<AirportEntity> listAirport = airportRepo.findAll();
		List<AiportDTO> listAirportDTO = new ArrayList<>();
		for (AirportEntity airportEntity : listAirport) {
			AiportDTO airportDto = convertAirport.EntityTOdto(airportEntity);
			listAirportDTO.add(airportDto);
		}
		return listAirportDTO;
	}
	@Override
	public AiportDTO updateAirport(AiportDTO aiportDTO, Long airportId) {
		Optional<AirportEntity> ae = airportRepo.findById(airportId);
		AiportDTO dto = null;
		if(ae.isPresent()) {
			AirportEntity airportEntity = ae.get();
			airportEntity.setIata(aiportDTO.getIata());
			airportEntity.setIcao(aiportDTO.getIcao());
			airportEntity.setAirport_name(aiportDTO.getAirport_name());
			dto = convertAirport.EntityTOdto(airportEntity);
			airportRepo.save(airportEntity);
		}
		return dto;
	}
	@Override
	public void deleteAirport(Long airportId) {
		airportRepo.deleteById(airportId);
		
	}

}
