package com.saraya.AirplaneType.mapper;

import com.saraya.AirplaneType.dto.AirplaneTypeDTO;
import com.saraya.AirplaneType.model.AirplaneType;

public class Mapper {
	public AirplaneType toEntity(AirplaneTypeDTO airplaneTypeDTO) {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setAirplane_type_identifier(airplaneTypeDTO.getAirplane_type_identifier());
		airplaneType.setDescription(airplaneTypeDTO.getDescription());
		return null;
	}
	
	
	public AirplaneTypeDTO toDto(AirplaneType airplaneType) {
		AirplaneTypeDTO airplaneTypeDTO = new AirplaneTypeDTO();
		airplaneTypeDTO.setAirplane_type_id(airplaneType.getAirplane_type_id());
		airplaneTypeDTO.setAirplane_type_identifier(airplaneType.getAirplane_type_identifier());
		airplaneTypeDTO.setDescription(airplaneType.getDescription());
		return null;
	}
}
