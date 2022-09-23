package com.saraya.airportservice.service;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDTO;
import com.saraya.airportservice.repository.AirportRepository;
import org.springframework.stereotype.Service;
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

    public List<Airport> getAll(){
        return repo.findAll();
    }

    public Airport getByIata(String iata){
        return repo.findByIata(iata);
    }

    public Airport create (AirportDTO dto){
        Airport airport = new Airport();
        RestTemplate template = new RestTemplate();
            Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("country"),dto.getCountry());
        UrlValues.put(("city"),dto.getCity());
        Integer airportGeoId = template.getForEntity(
                "http://localhost:8100/airportGeo/{country}/{city}",
                Integer.class, UrlValues)
                .getBody();
        changeToModel(dto, airport);
        airport.setAirportGeoId(airportGeoId);
        return repo.save(airport);
    }

    public Airport update(AirportDTO dto){
        Airport airport = new Airport();
        airport.setAirportId(dto.getAirportId());
        changeToModel(dto , airport);
        return repo.save(airport);
    }

    public static void changeToModel(AirportDTO dto , Airport airport){
        airport.setAirportName(dto.getAirportName());
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
    }

    public void deleteByIata(String iata){
        Airport airport = repo.findByIata(iata);
        repo.delete(airport);
    }
    public void deleteById(int airportId){
        repo.deleteById(airportId);
    }

    public Airport findByAirportName(String airportName) {
        return repo.findByAirportName(airportName);
    }
}
