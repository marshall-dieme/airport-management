package com.saraya.airportservice.service;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDto;
import com.saraya.airportservice.repository.AirportRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirportService {
    private final AirportRepository repo;


    public AirportService(AirportRepository repo) {

        this.repo = repo;
    }

 public List<Airport> getAirport(){

        return repo.findAll();
 }

 public Airport getById(Long airport_id){
        return repo.findById(airport_id).get();

 }


    public Airport CreateAirport(AirportDto dto) {
        Airport airport = new Airport();

        getRelation(dto, airport);

        return repo.save(airport);

    }

    private void getRelation(AirportDto dto, Airport airport) {
        RestTemplate template = new RestTemplate();
        Map<String, String> UrlValues= new HashMap<>();
        UrlValues.put("country", dto.getAirport_country());
        UrlValues.put("city", dto.getAirport_city());
        Long airport_geo_id = template.getForEntity("http://localhost:8080/airport_geo/country/city/{country}/{city}",
                Long.class, UrlValues)
                .getBody();
        changeToModel(dto, airport);
        airport.setAirport_geo_id(airport_geo_id);
    }

    private void changeToModel(AirportDto dto, Airport airport) {
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirport_name(dto.getAirport_name());


    }



    public Airport updateAirport(AirportDto dto){
        Airport airport = new Airport();
        airport.setAirport_id(dto.getAirport_id());
        changeToModel(dto, airport);
        getRelation(dto, airport);

        return repo.save(airport);
 }

 public void deleteAirport(Long airport_id){

        repo.deleteById(airport_id);
 }
 public Long getId(String airport_name){
        return repo.getIdAirport(airport_name);
 }

}
