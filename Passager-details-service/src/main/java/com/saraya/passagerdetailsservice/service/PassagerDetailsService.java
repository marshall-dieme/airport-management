package com.saraya.passagerdetailsservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.passagerdetailsservice.controller.PassagerDetailsController;
import com.saraya.passagerdetailsservice.model.PassagerDetails;
import com.saraya.passagerdetailsservice.model.PassagerDetailsDto;
import com.saraya.passagerdetailsservice.repository.PassagerDetailsRepo;


@Service
@Transactional
public class PassagerDetailsService {
	
	@Autowired
	private ModelMapper mapper;
	 private final Logger LOGGER = LoggerFactory.getLogger(PassagerDetailsController.class);

	private final PassagerDetailsRepo repo;
	
	public PassagerDetailsService(PassagerDetailsRepo repo) {
	
        this.repo = repo;
    }

    public List<PassagerDetails> getAll(){
        return repo.findAll();
    }
    
    public PassagerDetails getByEmail(
            String email){
        return repo.findByEmail(email);
    }
    
    public PassagerDetails create (PassagerDetailsDto dto){
    	PassagerDetails passagerDetails = mapper.map(dto, PassagerDetails.class);
    	try {
        RestTemplate template = new RestTemplate();
        Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("passportNo"), dto.getPassportNo());
        Integer passengerId = template.getForEntity(
                        "http://localhost:8900/passenger/passportNo/{passportNo}",
                        Integer.class, UrlValues)
                .getBody();
        assert passengerId != null;
        passagerDetails.setPassengerId(dto.getPassengerId());
        
        
    	}catch (Exception e) {
        	LOGGER.error(e.getMessage());
		}
        return repo.save(passagerDetails);

}
    public PassagerDetails update(PassagerDetailsDto dto){
    	PassagerDetails passagerDetails = new PassagerDetails();
    	passagerDetails.setPassengerDetailsId(dto.getPassengerDetailsId());
        return repo.save(passagerDetails);
    }
    
    public void deleteByPassportNo(String passportNo){
    	PassagerDetails passagerDetails = repo.findBypassportNo(passportNo);
        repo.delete(passagerDetails);
    }

    public void deleteBypassengerDetailsId(int passengerDetailsId){
        repo.deleteBypassengerDetailsId(passengerDetailsId);
    }

	

    
    
}