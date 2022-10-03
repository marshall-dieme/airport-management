package com.saraya.airline.service;

import com.saraya.airline.model.Airline;
import com.saraya.airline.model.AirlineDto;
import com.saraya.airline.repo.AirlineRepo;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirlineService {

    private final AirlineRepo repo;

    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();

    }

    public Long getIdAirline(String airlineName) {
        return repo.getIdAirline(airlineName);

    }



    public Airline create(AirlineDto dto){
        Airline airline = new Airline();
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("airportName", dto.getAirportName());

        Long airportId = template.getForEntity("http://localhost:8100/airport/airportName/{airportName}",
                Long.class, value).getBody();

        changeToModel(dto, airline);
        airline.setAirportId(airportId);
        return repo.save(airline);
    }

    public Airline update(AirlineDto dto){
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirlineId());
        changeToModel(dto, airline);
        return repo.save(airline);
    }


    public List <Airline> getAirlinesByAirport(String airportName) {
        Map<String, String> values = new HashMap<>();
        values.put("airportName", airportName);

        RestTemplate template = new RestTemplate();
        Long airportId;
        airportId = template.getForEntity("http://localhost:8100/airport/airportName/{airportName}",
                Long.class, values).getBody();

        return repo.findByAirportId(airportId);
    }
    private static void changeToModel(AirlineDto dto, Airline airline) {
        airline.setAirlineName(dto.getAirlineName());
        airline.setIata(dto.getIata());


    }

    public void deleteById(Long airline_id ){
        repo.deleteById(airline_id);
    }
}
