package com.saraya.airport.service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.model.AirportDto;
import com.saraya.airport.repo.Airport_Repo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirportService {

    private final Airport_Repo repo;


    public AirportService(Airport_Repo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){ return  repo.findAll();}

//    public Airport getById(Long airport_id){
//        return repo.findById(airport_id).get();
//    }

    public Long getIdAirport(String airport_name){
        return repo.getIdAirport(airport_name);
    }
    public Airport getAirportByAirportGeo(String city, String Country){
        Map<String,String> Values= new HashMap<>();
        Values.put("city", city);
        Values.put("Country", Country);
        RestTemplate template = new RestTemplate();
        Long idAirportGeo= template.getForEntity("http://localhost:8300/airport_geo/country/city/{country}/{city}",
                Long.class,Values).getBody();
        return  repo.findByIdAirportGeo(idAirportGeo);

    }

    public Airport create(AirportDto dto){
        Airport airport = new Airport();
        Map<String,String> urlValues= new HashMap<>();
        urlValues.put("country", dto.getAirportGeoCountry());
        urlValues.put("city", dto.getAirportGeoCity());
        RestTemplate template = new RestTemplate();
        Long idAirportGeo = template.getForEntity("http://localhost:8300/airport_geo/country/city/{country}/{city}",
                Long.class,urlValues).getBody();
        changeToModel(dto , airport);
        airport.setIdAirportGeo(idAirportGeo);
        return repo.save(airport);
    }

    private static void changeToModel(AirportDto dto , Airport airport ){
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirport_name(dto.getAirport_name());
    }
    public Airport update(AirportDto dto) {
        Airport airport = new Airport();
        airport.setAirport_id(dto.getAirport_id());
        changeToModel(dto, airport);
        return repo.save(airport);
    }


    public void deleteByName(Long airport_id) {
        repo.deleteById(airport_id);
    }
    public void delete(Long airport_id){
        repo.deleteById(airport_id);
    }
}
