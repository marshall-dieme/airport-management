package com.vlm.passengerdetails.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vlm.passengerdetails.model.Passenger;
import com.vlm.passengerdetails.model.PassengerDTO;
import com.vlm.passengerdetails.repository.PassengerRepository;


@Service
public class PassengerService {
	
	private final PassengerRepository repo;

    public PassengerService(PassengerRepository repo) {
        this.repo = repo;
    }

    public List<Passenger> getAll() {
        return repo.findAll();
    }
    
    public Optional<Passenger> getById(Long id) {
        return repo.findById(id);
    }
    
    public Passenger create(PassengerDTO dto) {
    	Passenger passenger = new Passenger();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("passenger", dto.getZip());
        String Zip = template.getForEntity(
                "http://localhost:8700/zip/passengers/{passengers}",
                        String.class,
                        urlValues)
                        .getBody();
        changeToModel(dto, passenger);
        passenger.setZip(Zip);
        return repo.save(passenger);
    }

	private void changeToModel(PassengerDTO dto, Passenger passenger) {
	
		passenger.setBirthdate(dto.getBirthdate());
		passenger.setSex(dto.getSex());
		passenger.setStreet(dto.getStreet());
		passenger.setCity(dto.getCity());
		passenger.setZip(dto.getZip());
		passenger.setCountry(dto.getCountry());
		passenger.setEmail(dto.getEmail());
		passenger.setTelephone(dto.getTelephone());
		
	}
		
	public void delete(Long id) {
        repo.deleteById(id);
    }
	
	
	public List<Passenger> getByZip(String zip) {
        Map<String, String> values = new HashMap<>();
        values.put("passengers", zip);
        RestTemplate template = new RestTemplate();
        String Zip = template.getForEntity("http://localhost:8700/zip/passengers/{passengers}",
                String.class, values).getBody();

        return repo.findByZip(Zip);
    }
	
	public Passenger createWithRelation(PassengerDTO dto) {
		Passenger passenger = new Passenger();
        changeToModel(dto, passenger);
        String Zip = new RestTemplate().getForEntity(
                "http://localhost:8700/passengers/passengers/"+dto.getZip(),
                String.class).getBody();
        passenger = repo.save(passenger);
        Map<String, String> values = new HashMap<>();
        values.put("Zip", Zip);
        values.put("Zip", String.valueOf(passenger.getZip()));
        new RestTemplate().getForEntity("http://localhost:8900/relation/{Zip}/{idPassenger}",
                Void.class, values);

        return passenger;
    }


}
