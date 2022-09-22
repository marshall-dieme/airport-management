package com.saraya.airplane.mapping;

import org.springframework.stereotype.Component;

import com.saraya.airplane.dto.AirplaneDTO;
import com.saraya.airplane.model.Airplane;
@Component
public class ConvertAirplane {
	public Airplane dtoTOEntity(AirplaneDTO airplaneDTO) {
		Airplane airplane = new Airplane();
		airplane.setCapacity(airplaneDTO.getCapacity());
		return airplane;
	}
	
	
	
	public AirplaneDTO EntityTOdto(Airplane airplane) {
		AirplaneDTO airplaneDTO = new AirplaneDTO();
		airplaneDTO.setAirplane_id(airplane.getAirplane_id());
		airplaneDTO.setCapacity(airplane.getCapacity());
		return airplaneDTO;
	}
}
