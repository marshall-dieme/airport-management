package com.saraya.airline.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.airline.dto.AirlineDTO;
import com.saraya.airline.mapping.ConvertAirline;
import com.saraya.airline.model.Airline;
import com.saraya.airline.repository.AirlineRepo;
import com.saraya.airline.services.Services;
@Service
public class AirlineService implements Services {
	@Autowired
	AirlineRepo airlineRepo;
	@Autowired
	ConvertAirline convertairline;
	@Override
	public AirlineDTO saveAirline(AirlineDTO airlineDTO) {
		Airline air = convertairline.dtoTOENtity(airlineDTO);
		airlineRepo.save(air);
		airlineDTO = convertairline.ENtityTOdto(air);
		return airlineDTO;
	}

	@Override
	public List<AirlineDTO> getAllAirline() {
		List<Airline> lair = airlineRepo.findAll();
		List<AirlineDTO> lairdto = new ArrayList<>();
		for (Airline airline : lair) {
			AirlineDTO dto = convertairline.ENtityTOdto(airline);
			lairdto.add(dto);
		}
		return lairdto;
	}

	@Override
	public AirlineDTO AirlineById(Long airlineId) {
		Optional<Airline> air = airlineRepo.findById(airlineId);
		AirlineDTO airdto = null;
		if(air.isPresent()) {
			airdto = convertairline.ENtityTOdto(air.get());
		}
		else {
			throw new RuntimeException("the id that you search is not exist......");
		}
		return airdto;
	}

	@Override
	public AirlineDTO updateAirline(AirlineDTO airlineDTO, Long id) {
		Optional<Airline> air = airlineRepo.findById(id);
		AirlineDTO dto = null;
		if(air.isPresent()) {
			Airline airline = air.get();
			airline.setIata(airlineDTO.getIata());
			airline.setAirline_name(airlineDTO.getAirline_name());
			dto = convertairline.ENtityTOdto(airline);
			airlineRepo.save(airline);
		}
		return dto;
	}

	@Override
	public void deleteAirline(Long id) {
		airlineRepo.deleteById(id);

	}

}
