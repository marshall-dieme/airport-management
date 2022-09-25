package com.saraya.AirplaneType.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.AirplaneType.dto.AirplaneTypeDTO;
import com.saraya.AirplaneType.mapper.Mapper;
import com.saraya.AirplaneType.model.AirplaneType;
import com.saraya.AirplaneType.repository.AirplaneTypeRepository;
import com.saraya.AirplaneType.services.AirplaneTypeService;

@Service
public class AirplaneTypeServiceImpl implements AirplaneTypeService{
	@Autowired
	private AirplaneTypeRepository repository;
	@Autowired
	private Mapper mapper;
	@Override
	public AirplaneTypeDTO create(AirplaneTypeDTO airplaneTypeDTO) {
		AirplaneType airplaneType = mapper.toEntity(airplaneTypeDTO);
		repository.save(airplaneType);
		return airplaneTypeDTO;
	}

	@Override
	public List<AirplaneTypeDTO> getAllAirplaneType() {
		List<AirplaneType> airplaneTypes = repository.findAll();
		List<AirplaneTypeDTO> airplaneTypeDTOs = new ArrayList<>();
		for (AirplaneType airplaneType : airplaneTypes) {
			AirplaneTypeDTO dto = mapper.toDto(airplaneType);
			airplaneTypeDTOs.add(dto);
		}
		return airplaneTypeDTOs;
	}

	@Override
	public AirplaneTypeDTO getAirplaneType(Long id) {
		Optional<AirplaneType> optional = repository.findById(id);
		AirplaneTypeDTO airplaneTypeDTO = null;
		if(optional.isPresent()) {
			AirplaneType airplaneType = optional.get();
			airplaneTypeDTO = mapper.toDto(airplaneType);
		}
		else {
			throw new RuntimeException("the id don't exist check again!!!!!!!!!!!!!!!!!!!!");
		}
		return airplaneTypeDTO;
	}

	@Override
	public AirplaneTypeDTO update(AirplaneTypeDTO airplaneTypeDTO, Long id) {
		Optional<AirplaneType> optional = repository.findById(id);
		AirplaneTypeDTO dto = null;
		if(optional.isPresent()) {
			AirplaneType airplaneType = optional.get();
			airplaneType.setAirplane_type_identifier(airplaneTypeDTO.getAirplane_type_identifier());
			airplaneType.setDescription(airplaneTypeDTO.getDescription());
			dto = mapper.toDto(airplaneType);
		}
		return dto;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
