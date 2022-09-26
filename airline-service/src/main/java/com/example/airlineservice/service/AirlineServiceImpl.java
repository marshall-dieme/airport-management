package com.example.airlineservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airlineservice.model.Airline;
import com.example.airlineservice.model.AirlineDTO;
import com.example.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private  ModelMapper modelmapper;
	
	@Autowired
	private final AirlineRepository repo;
	
	public AirlineServiceImpl(AirlineRepository airlineRepository) {
		repo = airlineRepository;
	}
	@Override
	public List<AirlineDTO> getAll() {
		// TODO Auto-generated method stub
		List<Airline> find = repo.findAll();
		List<AirlineDTO> airlineDTOs = new ArrayList<>();
		for(Airline a : find) {
			AirlineDTO dto = entityToDto(a);
			airlineDTOs.add(dto);
		}
		return airlineDTOs;
	}

	@Override
	public AirlineDTO getAilineById(Long id) {
		// TODO Auto-generated method stub
		Optional<Airline> get = repo.findById(id);
		Airline airline = null;
		if(get.isPresent()) {
			airline = get.get();
		}else {
			throw new RuntimeException("Didn't find Airline with id " +id);
		}
		AirlineDTO airlineDTO = entityToDto(airline);
		return airlineDTO;
	}

	@Override
	public AirlineDTO createAirline(AirlineDTO airlineDTO) {
		// TODO Auto-generated method stub
		Airline airline = new Airline();
		AirlineDTO airlineDTO2 = entityToDto(repo.save(airline));
		return airlineDTO2;
	}

	@Override
	public AirlineDTO updateAirline(AirlineDTO airlineDTO, Long id) {
		// TODO Auto-generated method stub
		AirlineDTO airDto = null;
		Optional<Airline> airline = repo.findById(id);
		if(airline.isPresent()) {
			Airline air = airline.get();
			air.setAirlineName(airlineDTO.getAirlineName());
			air.setIata(airlineDTO.getIata());
			airDto = entityToDto(air);
			
		}
		return airDto;
	}

	@Override
	public void deleteAirline(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	private Airline dtoToEntity(AirlineDTO dto) {
		Airline airline = modelmapper.map(dto, Airline.class);
		return airline;
	}
	
	private AirlineDTO entityToDto(Airline airline) {
		AirlineDTO dto = modelmapper.map(airline, AirlineDTO.class);
		return dto;
	}
}
