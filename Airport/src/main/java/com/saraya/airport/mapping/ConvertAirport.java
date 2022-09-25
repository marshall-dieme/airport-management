package com.saraya.airport.mapping;

import org.springframework.stereotype.Component;

import com.saraya.airport.dto.AiportDTO;
import com.saraya.airport.entity.AirportEntity;

@Component
public class ConvertAirport {
	public AirportEntity dtoTOEntity(AiportDTO aiportDTO) {
		AirportEntity ae = new AirportEntity();
		ae.setIata(aiportDTO.getIata());
		ae.setIcao(aiportDTO.getIcao());
		ae.setAirport_name(aiportDTO.getAirport_name());
		
		return ae;
	}
	
	public AiportDTO EntityTOdto(AirportEntity airportEntity) {
		AiportDTO apdto = new AiportDTO();
		apdto.setAirport_geo_id(airportEntity.getAirport_geo_id());
		apdto.setAirport_id(airportEntity.getAirport_id());
		apdto.setIata(airportEntity.getIata());
		apdto.setIcao(airportEntity.getIcao());
		apdto.setAirport_name(airportEntity.getAirport_name());
		return apdto;
	}
}
