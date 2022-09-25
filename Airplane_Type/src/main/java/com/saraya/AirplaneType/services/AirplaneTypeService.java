package com.saraya.AirplaneType.services;

import java.util.List;

import com.saraya.AirplaneType.dto.AirplaneTypeDTO;
import com.saraya.AirplaneType.model.AirplaneType;

public interface AirplaneTypeService {
	AirplaneTypeDTO create(AirplaneTypeDTO airplaneTypeDTO);
	List<AirplaneTypeDTO> getAllAirplaneType();
	AirplaneTypeDTO getAirplaneType(Long id);
	AirplaneTypeDTO update(AirplaneTypeDTO airplaneTypeDTO, Long id);
	void delete(Long id);
}
