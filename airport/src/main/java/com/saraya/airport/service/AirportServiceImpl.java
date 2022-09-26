package com.saraya.airport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.airport.model.Airport;
import com.saraya.airport.model.AirportDTO;
import com.saraya.airport.repository.AirportRepo;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	private final AirportRepo repo;
	
	public AirportServiceImpl(AirportRepo airportRepo) {
		repo =airportRepo;
	}
	@Override
	public List<Airport> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Airport getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Airport> result = repo.findById(id);
		Airport airport =null;
		if(result.isPresent()) {
			airport = result.get();
		}
		else {
			throw new RuntimeException("Didn't find airport with id " +id);
		}
		return airport;
	}
	@Override
	public Long getByName(String airportName) {
		return repo.getByName(airportName);
	}
	@Override
	public Airport create(AirportDTO dto) {
		// TODO Auto-generated method stub
		  	Airport airport= new Airport();
	        RestTemplate template = new RestTemplate();
	        Map<String, String> values = new HashMap<>();
	        values.put("city", dto.getCity());
	        values.put("country", dto.getCountry());
	        Long airportGeoId = template.getForEntity("http://localhost:8000/geo/country/city/{country}/{city}",
	                Long.class, values).getBody();
	        changeToModel(dto, airport);
	        airport.setAirportGeoId(airportGeoId);;
	        return repo.save(airport);
	}
	@Override
	public Airport getAirportByAirportGeo(String country, String city) {
		// TODO Auto-generated method stub
			Airport airport = new Airport();
			RestTemplate template = new RestTemplate();
			Map<String, String> values = new HashMap<>();
			values.put("country", country);
			values.put("city", city);
			Long airportGeoId = template.getForEntity("http://localhost:8000/geo/country/city/{country}/{city}",
	                Long.class, values).getBody();
			airport.setAirportGeoId(airportGeoId);
			return repo.findByAirportGeoId(airportGeoId);
	}
	@Override
	public AirportDTO update(AirportDTO dto, Long id) {
		// TODO Auto-generated method stub
		AirportDTO airportDTO = null;
		 Optional<Airport> result =repo.findById(id);
		 if(result.isPresent()) {
			 Airport airport = result.get();
;			  airport.setAirportId(dto.getAirportId());
			  airport.setAirportName(dto.getAirportName());
			  airport.setIata(dto.getIata());
			  airport.setIcao(dto.getIcao());
		      airportDTO = convertToDto(airport);
		      airport = repo.save(airport);
		 }
	       return airportDTO ;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	 private static void changeToModel(AirportDTO dto, Airport airport) {
		 	airport.setAirportName(dto.getAirportName());
	        airport.setIata(dto.getIata());
	        airport.setIcao(dto.getIcao());
	    }
	 private static AirportDTO convertToDto(Airport airport) {
		 AirportDTO dto = new AirportDTO();
		 dto.setAirportName(airport.getAirportName());
		 dto.setIata(airport.getIata());
		 dto.setIcao(airport.getIcao());
		 return dto;
	 }
}
