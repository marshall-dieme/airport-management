package com.saraya.airelineservice.service;

import com.saraya.airelineservice.model.Airline;
import com.saraya.airelineservice.model.AirlineDTo;
import com.saraya.airelineservice.repos.AirlineRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AirlineService {

    private final AirlineRepo repo;

    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();

    }

    public Long getIdAirline(String airline_name) {
        return repo.getIdAirline(airline_name);

    }



    public Airline create(AirlineDTo dto){
        Airline airline = new Airline();
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("airport_name", dto.getAirport_name());

        Long idAirport = template.getForEntity("http://localhost:8200/airports/airportName/{airport_name}",
                Long.class, value).getBody();

        changeToModel(dto, airline);
        airline.setIdAirport(idAirport);
        return repo.save(airline);
    }

    public Airline update(AirlineDTo dto){
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirline_id());
        changeToModel(dto, airline);
        return repo.save(airline);
    }


    public List <Airline> getAirlinesByAirport(String airportName) {
        Map<String, String> values = new HashMap<>();
        values.put("airport_name", airportName);

        RestTemplate template = new RestTemplate();
        Long idAirport = template.getForEntity("http://localhost:8200/airports/airportName/{airport_name}",
                Long.class, values).getBody();

        return repo.findByIdAirport(idAirport);
    }

    private static void changeToModel(AirlineDTo dto, Airline airline) {
        airline.setAirline_name(dto.getAirline_name());
        airline.setIata(dto.getIata());


    }



    public void delete(Long id ){
        repo.deleteById(id);
    }
}