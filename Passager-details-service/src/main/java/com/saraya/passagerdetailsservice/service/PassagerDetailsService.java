package com.saraya.passagerdetailsservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public PassagerDetails getByEmail(String email){
        return repo.findByEmail(email);
    }
    
    public PassagerDetailsDto create (PassagerDetailsDto dto){
    	PassagerDetails passagerDetails = mapper.map(dto, PassagerDetails.class);
    		passagerDetails =repo.save(passagerDetails);
    		PassagerDetailsDto detailsPassenger = mapper.map(passagerDetails, PassagerDetailsDto.class);
        return detailsPassenger;

}
    public PassagerDetails update(PassagerDetailsDto passagerDetailsDto){
    	((Throwable) LOGGER).getMessage();
        return repo.save(mapper.map(passagerDetailsDto, PassagerDetails.class));
    }
    
    public void deleteByPassportNo(String passportNo){
    	PassagerDetails passagerDetails = repo.findBypassportNo(passportNo);
        repo.delete(passagerDetails);
    }

    public void deleteBypassengerDetailsId(int passengerDetailsId){
        repo.deleteBypassengerDetailsId(passengerDetailsId);
    }
}