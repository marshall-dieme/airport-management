package com.saraya.microservice.airportservice.service;

import com.saraya.microservice.airportservice.model.Airport;
import com.saraya.microservice.airportservice.model.AirportDto;
import com.saraya.microservice.airportservice.repo.AirportRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AirportService {
    private final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){
        return repo.findAll();
    }

    public Airport getById(int airport_id) {
        return repo.findById(airport_id).get();
    }

    public Airport create(AirportDto dto) {
        Airport a = new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put(
                "country", dto.getCountry());
        urlValues.put(
                "city", dto.getCity());
        Integer idGeo = template.getForEntity(
                "http://localhost:8700/arpgs/country/city/{country}/{city}",
                Integer.class,
                urlValues)
                .getBody();
        changeToModel(dto, a);
       a.setIdGeo(idGeo);

        return repo.save(a);

    }

    public Airport getCountryCity(String country,String city){

        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put(
                "country", country);
        urlValues.put(
                "city", city);
        Integer idGeo = template.getForEntity(
                "http://localhost:8700/arpgs/country/{country}/city/{city}",
                Integer.class,
                urlValues)
                .getBody();
        return repo.getAirportsByIdGeo(idGeo);


    }

    private static void changeToModel(AirportDto dto, Airport a) {
        a.setIata(dto.getIata());
        a.setIcao(dto.getIcao());
        a.setAirport_name(dto.getAirport_name());
    }

    public Airport update(AirportDto dto) {
        Airport a = new Airport();
        a.setAirport_id(dto.getAirport_id());
            changeToModel(dto, a);
            return repo.save(a);


    }

    public void delete(int airport_id) {
        repo.deleteById(airport_id);
    }


    /*public Airport getIdArp(String airport_name) {
        return repo.findAirportByAirport_name(airport_name);
    }*/
}
