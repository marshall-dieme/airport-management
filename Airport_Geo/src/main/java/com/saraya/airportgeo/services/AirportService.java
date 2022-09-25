package com.saraya.airportgeo.services;

import java.util.List;

import com.saraya.airportgeo.dto.AirportGeoDTO;
import com.saraya.airportgeo.model.AirportGeo;



public interface AirportService {
	AirportGeoDTO saveAirportGeo(AirportGeoDTO airportGeoDTO);
	List<AirportGeoDTO> getAll();
	AirportGeoDTO getAiportGeoById(Long airportgeoId);
	AirportGeoDTO updateAirportGeo(AirportGeoDTO airportGeoDTO, Long airportgeoId);
	void deleteAirportGeo(Long airportgeoId);
	AirportGeoDTO findByCountryAndCity(String country, String city);

}
