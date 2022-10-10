package com.saraya.airportgeoservice.service;

import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.dto.AirportGeoDto;
import com.saraya.airportgeoservice.mapper.AirportGeoMapper;
import com.saraya.airportgeoservice.repo.AirportGeoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirportGeoService {

    private final AirportGeoRepo repo;

    public AirportGeoService(AirportGeoRepo repo) {
        this.repo = repo;
    }

   AirportGeoMapper mapper = new AirportGeoMapper();

    public String putAirportIdforAirportGeoId(int airportGeoid, String airportName) {
        AirportGeo airportGeo = getById(airportGeoid);
        RestTemplate restTemplate = new RestTemplate();
        int airportId = restTemplate.getForEntity("http://localhost:8004/Airport/"+airportName, Integer.class).getBody();
        airportGeo.setAirportId(airportId);
        repo.save(airportGeo);
        return "add succefull";
    }

    public List<AirportGeo> getAll(){
        return repo.findAll();
    }

    public AirportGeo getById(int id){
        return repo.findById(id).get();
    }

    public AirportGeo create(AirportGeoDto dto){
        return repo.save(mapper.toEntity(dto));
    }

    public AirportGeo update(AirportGeoDto airportGeo){
        return repo.save(mapper.toEntity(airportGeo));
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public int getIdByCountryAndCity(String country, String city) {
        return  repo.findByCountryAndCity(country, city).get().getAirportGeoId();
    }

}
