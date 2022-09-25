package com.saraya.airportgeo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.airportgeo.dto.AirportGeoDTO;
import com.saraya.airportgeo.mapping.ConvertDtoTOEntity;
import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.repository.AirportGeoRepository;
import com.saraya.airportgeo.services.AirportService;
@Service
public class ServiceImpl implements AirportService{
	@Autowired
	private AirportGeoRepository airportGeoRepository;
	@Autowired
	private ConvertDtoTOEntity convertDtoTOEntity;
	@Override
	public AirportGeoDTO saveAirportGeo(AirportGeoDTO airportGeoDTO) {
		AirportGeo ag = convertDtoTOEntity.dtoToEntity(airportGeoDTO);
		ag = airportGeoRepository.save(ag);
		airportGeoDTO = convertDtoTOEntity.EntityTodto(ag);
		return airportGeoDTO;
	}

	@Override
	public List<AirportGeoDTO> getAll() {
		List<AirportGeo> agl = airportGeoRepository.findAll();
		List<AirportGeoDTO> agld = new ArrayList<>();
		for (AirportGeo airportGeo : agl) {
			AirportGeoDTO airportGeoDTO = convertDtoTOEntity.EntityTodto(airportGeo);
			agld.add(airportGeoDTO);
		}
		return agld;
	}

	@Override
	public AirportGeoDTO getAiportGeoById(Long airportgeoId) {
		Optional<AirportGeo> ag = airportGeoRepository.findById(airportgeoId);
		AirportGeoDTO agd = null;
		if(ag.isPresent()) {
			 agd = convertDtoTOEntity.EntityTodto(ag.get());
		}
		else {
			throw new RuntimeException("Did not find AirportGeo id - " + airportgeoId);
		}
		return agd;
	}

	@Override
	public AirportGeoDTO updateAirportGeo(AirportGeoDTO airportGeoDTO, Long airportgeoId) {
		Optional<AirportGeo> ag = airportGeoRepository.findById(airportgeoId);
		AirportGeoDTO dto =null;
		if(ag.isPresent()) {
			AirportGeo ap = ag.get();
			ap.setCity(airportGeoDTO.getCity());
			ap.setCountry(airportGeoDTO.getCountry());
			dto = convertDtoTOEntity.EntityTodto(ap);
			airportGeoRepository.save(ap);
		}
		return dto;
	}

	@Override
	public void deleteAirportGeo(Long airportgeoId) {
		airportGeoRepository.deleteById(airportgeoId);
		
	}

	@Override
	public AirportGeoDTO findByCountryAndCity(String country, String city) {
		AirportGeo airportGeo = airportGeoRepository.findByCountryAndCity(country, city);
		return convertDtoTOEntity.EntityTodto(airportGeo);
	}
	

}
