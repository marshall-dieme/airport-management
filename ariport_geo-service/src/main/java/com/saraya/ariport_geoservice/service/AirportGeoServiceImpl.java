package com.saraya.ariport_geoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saraya.ariport_geoservice.model.AirportGeo;
import com.saraya.ariport_geoservice.repo.AirportGeoRepo;

@Service
public class AirportGeoServiceImpl implements AirportGeoService{

	 
	private final AirportGeoRepo repo;
	
	public AirportGeoServiceImpl(AirportGeoRepo theRepo) {
		repo = theRepo;
	}
	@Override
	public List<AirportGeo> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public AirportGeo getById(Long id) {
		// TODO Auto-generated method stub
		Optional<AirportGeo> result = repo.findById(id);
		AirportGeo airportGeo = null;
		if(result.isPresent()) {
			airportGeo =result.get();
		}
		else {
			throw new RuntimeException("Didn't find AirportGeo id " +id); 
		}
		return airportGeo;
	}

	@Override
	public AirportGeo create(AirportGeo airportGeo) {
		return repo.save(airportGeo);
	}

	@Override
	public AirportGeo update(AirportGeo airportGeo, Long id) {
		
		Optional<AirportGeo> result =repo.findById(id);
		AirportGeo airpo = new AirportGeo();
		if(result.isPresent()) {
			airpo = result.get();
			airpo.setCity(airportGeo.getCity());
			airpo.setCountry(airportGeo.getCountry());
			repo.save(airpo);
		}
		else {
			throw new RuntimeException("Can't update the Airport with id " +id);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
			}
		return airpo;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	@Override
	public Long getAirportGeoId(String country, String city) {
		return repo.getAirportGeoId(country, city);
	}
	@Override
	public AirportGeo getByCountryAndCity(String country, String city) {
		
		return repo.findByCountryAndCity(country, city);
	}
	
}
