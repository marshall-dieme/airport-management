package com.saraya.microserviceairlines.servicesImpl;

import com.saraya.microserviceairlines.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairlines.models.Airline;
import com.saraya.microserviceairlines.repositories.AirlineRepository;
import com.saraya.microserviceairlines.services.AirlineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineImp implements AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineImp(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline add(Airline airline) {
        return this.airlineRepository.save(airline);
    }

    @Override
    public Airline update(Airline airline) {
        return this.airlineRepository.save(airline);
    }

    @Override
    public Airline getAirline(Long airline_id) throws ResourceNotFoundException {
        Optional<Airline> airline = this.airlineRepository.findById(airline_id);
        if (!airline.isPresent())
            throw new ResourceNotFoundException("Airline not available");
        return airline.get();
    }

    @Override
    public Page<Airline> getAirlines(Pageable pageable) {
        return this.airlineRepository.findAll(pageable);
    }

    @Override
    public void delete(Long airline_id) throws ResourceNotFoundException {
      if (!this.existAirline(airline_id))
          throw new ResourceNotFoundException("impossible to remove this Airline");

      this.airlineRepository.deleteById(airline_id);
    }

    @Override
    public boolean existAirline(Long airline_id) {
        return this.airlineRepository.existsById(airline_id);
    }
}
