package com.saraya.passagerservice.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.saraya.passagerservice.model.Passenger;
import com.saraya.passagerservice.repository.PassengerRepository;


@Service
@Transactional
public class PassengerService {
	 private final PassengerRepository repo;
	 
	public PassengerService(PassengerRepository repo) {
		this.repo = repo;
	}
	
	public List<Passenger> getAll(){
        return repo.findAll();
	}
	
	 public  Passenger getByPassportNo(
	            String passportNo){
	        return repo.findByPassportNo(passportNo);
	    }

	 public Passenger create (Passenger passenger){
	        return repo.save(passenger);
	    }
	 
	 public Passenger update(Passenger passenger){
	        return repo.save(passenger);
	    }
	 
	 public void deleteByPassportNo(String passportNo ){
		 Passenger passenger = repo.findByPassportNo(passportNo);
	        repo.delete(passenger);
	    }
	    public void deleteByPassengerId(int passengerId){
	        repo.deleteByPassengerId(passengerId);
	    }


	    public Passenger findByPassportNo(String passportNo ) {
	        return repo.findByPassportNo(passportNo);
	    }

	 
	 


}
