package com.microservices.airline.Passager_Details.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.airline.Passager_Details.entity.PassagerDetails;
import com.microservices.airline.Passager_Details.entity.PassagerDetailsDto;
import com.microservices.airline.Passager_Details.repository.PassagerDetailsRepository;

@Service
public class PassagerDetailsService {

	private final PassagerDetailsRepository repo;

	public PassagerDetailsService(PassagerDetailsRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
	public List<PassagerDetails> getPassagerDetails() {
		return repo.findAll();
	}
	
	
	public Optional<PassagerDetails> getById(String id) {
		return repo.findById(id);
	}
	
	
	public  void delete(String id) {
		repo.deleteById(id);
	}
	
	
	
	public PassagerDetails create(PassagerDetailsDto dto) {
		
		PassagerDetails pasdetails = new PassagerDetails();
		RestTemplate template = new RestTemplate();
		 Map<String, String> urlValues = new HashMap<>();
		 urlValues.put("passportno", dto.getPassportno());
		 String idPassager = template.getForEntity("http://localhost:8300/passager/passportNo/{passportno}",
				 String.class,
				 urlValues)
				 .getBody();
		 changeToModel(dto, pasdetails);
		 pasdetails.setIdpass(idPassager);
		 
		 pasdetails.generateId();
		
		return repo.save(pasdetails);
	}



	private void changeToModel(PassagerDetailsDto dto, PassagerDetails pasdetails) {
		pasdetails.setCity(dto.getCity());
		pasdetails.setCountry(dto.getCountry());
		pasdetails.setEmail(dto.getEmail());
		pasdetails.setSex(dto.getSex());
		pasdetails.setStreet(dto.getStreet());
		pasdetails.setTelephone(dto.getTelephone());
		pasdetails.setZip(dto.getZip());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
        pasdetails.setBirthdate(birthdate);
		
	}
	
	
	public PassagerDetails update(PassagerDetailsDto dto) {
		PassagerDetails pass = new PassagerDetails();
		pass.setId(dto.getId());
		changeToModel(dto, pass);
		return repo.save(pass);
		
	}
	
	
	public PassagerDetails findDetailsByPassager(String passportno){
		RestTemplate template = new RestTemplate();
		Map<String, String> urlValues = new HashMap<>();
		urlValues.put("passportno", passportno);
		String idPassager = template.getForEntity("http://localhost:8300/passager/passportNo/{passportno}",
				String.class,
				urlValues)
				.getBody();
		return repo.findByIdpass(idPassager);

	}
	
	
	
}
