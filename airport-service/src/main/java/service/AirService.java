package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import model.Airport;
import repository.AirRepo;

@Service
@Transactional
public class AirService {
	private final AirRepo repo;

	public AirService(AirRepo repo) {
		
		this.repo = repo;
	}
	public List<Airport>getAll(){
		return repo.findAll();
	}
	
	public Airport rerieveByNameAirport(String airport_name) {
		return repo.retrieveByName(airport_name);
	}
	public Airport Create(Airport airport) {
		return repo.save(airport);
	}
	
	public Airport Update(Airport airport) {
		return repo.save(airport);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	

}
