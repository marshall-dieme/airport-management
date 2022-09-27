package com.saraya.airportservice.service;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.dto.AirportDto;
import com.saraya.airportservice.repo.AirportRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {

    private final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){
        return repo.findAll();
    }

//    public Optional<Airport> getByName(String name){
//        return repo.findByName(name);
//    }

    public Airport create(AirportDto dto){
        return repo.save(toEntity(dto));
    }

    public AirportDto update(AirportDto dto){
       repo.save(toEntity(dto));
       return dto;
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public Airport toEntity(AirportDto dto){
        Airport airport = new Airport();
        airport.setAirportId(dto.getAirportId());
        airport.setIata(dto.isIata());
        airport.setIcao(dto.isIcao());
        airport.setAirportGeoId(dto.getAirportGeoId());
        airport.setName(dto.getName());
        return airport;
    }

    public Airport putIdAirportGeoForAirport(int idAirport, String country, String city) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("country", country);
        urlValues.put("city", city);

        int idAirportGeo = restTemplate.getForEntity("http://localhost:8005/AirportGeo/{country}/{city}",
                Integer.class, urlValues).getBody();

        Airport airport =  repo.findById(idAirport).get();
        airport.setAirportGeoId(idAirportGeo);

        Map<String, Integer> urlValues1 = new HashMap<>();
        urlValues1.put("idAirport", idAirport);
        urlValues1.put("idAirportGeo", idAirportGeo);
        new RestTemplate().getForEntity("http://localhost:8005/AirportGeo/put/{idAirport}/{idAirportGeo}",
                void.class, urlValues1);

        return repo.save(airport);
    }

    public Airport putServiceForAirport(int idAirport, String serviceName) {
        Airport airport = repo.findById(idAirport).get();

        RestTemplate restTemplate = new RestTemplate();
        int idService = restTemplate.getForEntity("http://localhost:8007/Services/"+serviceName,
                        Integer.class).getBody();
        System.out.println(idService);
        airport.getServiceId().add(idService);
        return repo.save(airport);
    }

    public Airport putAirlineForAirport(int idAirport, String airlineName) {
        Airport airport = repo.findById(idAirport).get();

        RestTemplate restTemplate = new RestTemplate();
        int idAirline = restTemplate.getForEntity("http://localhost:8001/Airline/"+airlineName,
                Integer.class).getBody();

        airport.getAirlineId().add(idAirline);
        return repo.save(airport);
    }

    public int getIdAirportByName(String name){
        return repo.findByName(name).getAirportId();
    }
}
