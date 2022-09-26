package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Airport_Geo;
import repo.AirportgeoRepo;
@Service
public class AirportgeoService {
	private final AirportgeoRepo repo;

	public AirportgeoService(AirportgeoRepo repo) {
		
		this.repo = repo;
	}
	public List<Airport_Geo>getAll(){
		return repo.findAll();
	}
	public Airport_Geo getById(Long airport_geo_id) {
		return repo.getById(airport_geo_id);
	}
	public Airport_Geo create(Airport_Geo airport_geo) {
		return repo.save(airport_geo);
	}
	
	public Airport_Geo update(Airport_Geo airport_geo) {
		return repo.save(airport_geo);
	}
	public void  delete(Airport_Geo airport_geo) {
		repo.delete(airport_geo);
	}
	public void deleteById(long  airport_geo_id) {
		Airport_Geo airport_geo = repo.findById(airport_geo_id);
		repo.delete(airport_geo);
		
	}

}
