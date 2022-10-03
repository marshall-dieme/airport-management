package com.saraya.microserviceairlines.services;

import com.saraya.microserviceairlines.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairlines.models.Airline;
import com.saraya.microserviceairlines.repositories.AirlineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AirlineServiceImp implements AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineServiceImp(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline add(Airline airline) throws ResourceNotFoundException {
        return getAirline(airline) ;
    }

    @Override
    public Airline update(Airline airline) throws ResourceNotFoundException {
        return getAirline(airline) ;
    }
    private Airline getAirline(Airline airline) throws ResourceNotFoundException {

        if(airline.getAirplaneId()!=null){
            try {
                Map<String,Long> paramAirplines = new HashMap<>();
                paramAirplines.put("airpline_id",airline.getAirplaneId());
                Long airplineId = new RestTemplate().getForEntity("http://localhost:9002/airplines/airpline_id/{airpline_id}",
                        Long.class,paramAirplines).getBody();

                airline.setAirplaneId( airplineId);
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Airpline ID = %d not found",airline.getAirplaneId()));
            }

        }

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
