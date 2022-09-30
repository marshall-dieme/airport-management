package com.saraya.Flight.service;

import java.util.List;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.Flight.controller.FlightController;
import com.saraya.Flight.model.Flight;
import com.saraya.Flight.model.FlightDto;
import com.saraya.Flight.repository.FlightRepo;

@Service
@Transactional
public class FlightService {
	@Autowired
	private ModelMapper mapper;
	private final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }

    public List<Flight> getAll(){
        return repo.findAll();
    }

    public Flight getByFlightNo(String flightNo){
        return repo.findByFlightNo(flightNo);
    }

    public Flight create ( FlightDto dto){
    	Flight flight = mapper.map(dto, Flight.class);   	
    	Exception e =new Exception() ; 
    	LOGGER.error(e.getMessage());
        return repo.save(flight);
    }

    public Flight update(Flight flight){
        return repo.save(flight);
    }
    
    public void deleteByFlightNo(String flightNo){
        Flight flight = repo.findByFlightNo(flightNo);
        repo.delete(flight);
    }

    public void deleteById(int flightId){
        repo.deleteById(flightId);
    }

	public Flight findById(int flightId) {
		return repo.findByFlightId(flightId);
	}
}
