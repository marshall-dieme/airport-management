package com.saraya.airplane.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.airplane.dto.AirplaneDTO;
import com.saraya.airplane.mapping.ConvertAirplane;
import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.repository.AirplaneRepository;
import com.saraya.airplane.services.Services;
@Service
public class AirplaneService implements Services {
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private ConvertAirplane convertAirplane;
	@Override
	public AirplaneDTO saveAirplane(AirplaneDTO airplaneDTO) {
		Airplane ap = convertAirplane.dtoTOEntity(airplaneDTO);
		airplaneRepository.save(ap);
		airplaneDTO = convertAirplane.EntityTOdto(ap);
		return airplaneDTO;
	}

	@Override
	public List<AirplaneDTO> getAllAirplane() {
		List<Airplane> airplanes = airplaneRepository.findAll();
		List<AirplaneDTO> airplaneDTOs = new ArrayList<>();
		for (Airplane airplane : airplanes) {
			AirplaneDTO dto = convertAirplane.EntityTOdto(airplane);
			airplaneDTOs.add(dto);
		}
		return airplaneDTOs;
	}

	@Override
	public AirplaneDTO AirlineById(Long airplaneId) {
		Optional<Airplane> optional = airplaneRepository.findById(airplaneId);
		AirplaneDTO airplaneDTO = null;
		if(optional.isPresent()) {
			Airplane airplane = optional.get();
		 airplaneDTO = convertAirplane.EntityTOdto(airplane);
		}
		else {
			throw new RuntimeException("the id don't exist check again!!!!!!!!!!!!!!!!!!!!");
		}
		return airplaneDTO;
	}

	@Override
	public AirplaneDTO updateAirplane(AirplaneDTO airplaneDTO, Long id) {
		Optional<Airplane> optA = airplaneRepository.findById(id);
		AirplaneDTO dto = null;
		if(optA.isPresent()) {
			Airplane airplane = optA.get();
			airplane.setCapacity(airplaneDTO.getCapacity());
			dto = convertAirplane.EntityTOdto(airplane);
			airplaneRepository.save(airplane);
		}
		return dto;
	}

	@Override
	public void deleteAirplane(Long id) {
		airplaneRepository.deleteById(id);

	}

}
