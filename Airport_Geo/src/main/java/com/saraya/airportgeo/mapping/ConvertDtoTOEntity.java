package com.saraya.airportgeo.mapping;

import org.springframework.stereotype.Component;

import com.saraya.airportgeo.dto.AirportGeoDTO;
import com.saraya.airportgeo.model.AirportGeo;

@Component
public class ConvertDtoTOEntity {
	
	
	public AirportGeo dtoToEntity(AirportGeoDTO airportGeoDTO) {
		AirportGeo ap = new AirportGeo();
		ap.setCity(airportGeoDTO.getCity());
		ap.setCountry(airportGeoDTO.getCountry());
		return ap;
	}
	
	public AirportGeoDTO EntityTodto(AirportGeo airportGeo) {
		AirportGeoDTO apdto = new AirportGeoDTO();
		apdto.setAirport_geo_id(airportGeo.getAirport_geo_id());
		apdto.setCity(airportGeo.getCity());
		apdto.setCountry(airportGeo.getCountry());
		return apdto;
	}
}
