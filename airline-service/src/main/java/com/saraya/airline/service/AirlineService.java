package com.saraya.airline.service;

import com.saraya.airline.model.Airline;
import com.saraya.airline.model.AirlineDto;
import com.saraya.airline.repository.AirlineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirlineService {
    private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    public List<Airline> getAllAirline(){
        return repo.findAll();
    }

    public  Airline getAirlineId(Long airline_id){

        return repo.findById(airline_id).orElse(null);
    }

    //public Airline createAirline(Airline airline){
        //return repo.save(airline);
    //}


    public Airline updateAirline(AirlineDto dto){


        Airline airline=new Airline();
        changeToModel(dto, airline);
        getRelation(dto, airline);
        return repo.save(airline);

    }

    public Airline createAirline(AirlineDto dto) {
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirline_id());
        changeToModel(dto, airline);

        getRelation(dto, airline);

        return repo.save(airline);

    }

    private void getRelation(AirlineDto dto, Airline airline) {
        RestTemplate template = new RestTemplate();
        Map<String, String> UrlValues= new HashMap<>();
        UrlValues.put("airport_name", dto.getAirport_name());
        Long airport_id = template.getForEntity("http://localhost:8081/airport/airport_name/{airport_name}",
                Long.class, UrlValues)
                .getBody();
        changeToModel(dto, airline);
        airline.setAirport_id(airport_id);
    }

    private void changeToModel(AirlineDto dto, Airline airline) {
        airline.setIata(dto.getIata());
        airline.setAirline_name(dto.getAirline_name());

    }




    public void deleteAirline(Long airline_id){


        repo.deleteById(airline_id);
    }

    public long getAirlineId(String airline_name, String iata){

        return repo.getIdAirline(airline_name,iata);
    }


}
