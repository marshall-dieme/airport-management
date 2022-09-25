package com.spring.airportservices.service;


import com.spring.airportservices.DTO.AirportDto;
import com.spring.airportservices.bean.Airport;
import com.spring.airportservices.repo.AirportRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class AirportService {

    private  final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    //<Retreive all users>
    public List<Airport>getAll(){
        return repo.findAll();
    }

    //re retreive one user by id
    public Optional<Airport> getById(int id) {
        return repo.findById(id);
    }

    //<Add new user>
    public Airport create(AirportDto airportDto){
        Airport airport = new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("city",airportDto.getCity());
        urlValues.put("country",airportDto.getCountry());
        String airportGeoId = template.getForEntity(
                "http://localhost:8300/airportgeo/city/country/{city}/{country}",
                String.class,
                urlValues).
                getBody();
        changeToModel(airportDto,airport);
        airport.setAirportGeoId(airportGeoId);
        return repo.save(airport);
    }

    //get airportGeoId by city and country
    public List<Airport> getAirportByAirportGeo(String city, String country){
        Map<String,String> values= new HashMap<>();
        values.put("city", city);
        values.put("country",country);
        RestTemplate restTemplate = new RestTemplate();
        String airportGeoId = restTemplate.getForEntity(
                "http://localhost:8300/airportgeo/city/country/{city}/{country}",
                String.class,values).getBody();
        return repo.findByAirportGeoId(airportGeoId);
    }

    //<Add new user>
    /*public  Airport create(Airport airport){
        return repo.save(airport);
    }*/

    //<Edit user by id>

    public Airport update(AirportDto airportDto){
        Airport airport = new Airport();
        airport.setAirportId(airportDto.getAirportId());
        airport.setAirportGeoId(airportDto.getAirportGeoId());
        changeToModel(airportDto,airport);
        return repo.save(airport);
    }
  /* public Airport update(int id, Airport airport){
        Airport airport1=repo.findByAirportId(id);
        airport1.setAirportName(airport.getAirportName());
        airport1.setIata(airport.getIata());
        airport1.setIacao(airport.getIacao());
        return repo.save(airport1);
    }*/

    //<Delete user by id>
    public void delete(int id){
         repo.deleteById(id);
    }

    public static void changeToModel(AirportDto dto, Airport airport){
        airport.setAirportName(dto.getAirportName());
        airport.setIacao(dto.getIacao());
        airport.setIata(dto.getIata());
//        airport.setAirportGeoId(dto.getAirportGeoId());
    }

    public int getAirportId(String airportName){
        return repo.findByAirportName(airportName).getAirportId();
    }

  /*  public List<Airport> getByAirportGeo(String name){
        Map<String, String> values = new HashMap<>();
        values.put("name", name);
        RestTemplate template = new RestTemplate();
        String airportGeotId = template.getForEntity("http://localhost:8300/airportgeo/name/name",String.class
        ,values).getBody();
        return repo.findByAirportGeoId(airportGeotId);
    }*/
}
