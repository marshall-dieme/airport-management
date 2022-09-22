package com.saraya.airlineservice.service;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.model.AirlineDTO;
import com.saraya.airlineservice.repository.AirlineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirlineService {

    private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }
    public Airline getByAirlineName(
            String airlineName){
        return repo.findByAirlineName(airlineName);
    }

    public Airline create (AirlineDTO dto){
        Airline airline = new Airline();
        RestTemplate template = new RestTemplate();
        Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("airportName"), dto.getAirportName());
        Integer airportId = template.getForEntity(
                        "http://localhost:8083/airport/airportName/{airportName}",
                        Integer.class, UrlValues)
                .getBody();
        changeToModel(dto, airline);
       // assert airportId != null;
        airline.setAirportId(airportId);
        return repo.save(airline);
    }

    public Airline update(AirlineDTO dto){
        Airline airline = new Airline();
        airline.setAirlineId(dto.getAirlineId());
        changeToModel(dto , airline);
        return repo.save(airline);
    }

    public static void changeToModel(AirlineDTO dto , Airline airline){
        //airline.setAirportId(dto.getAirportId());
        airline.setAirlineName(dto.getAirlineName());
        airline.setIata(dto.getIata());
        //airline.setAirportName(dto.getAirportName());
    }

    public void deleteByAirlineName(String airlineName){
        Airline airline = repo.findByAirlineName(airlineName);
        repo.delete(airline);
    }

    public void deleteById(int airlineId){
        repo.deleteById(airlineId);
    }

}
