package com.saraya.airportservice.service;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDTO;
import com.saraya.airportservice.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirportService {

    @Autowired
    private ModelMapper mapper;

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
        Airport airport = mapper.map(dto , Airport.class);
        RestTemplate template = new RestTemplate();
            Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("country"),dto.getCountry());
        UrlValues.put(("city"),dto.getCity());
        Integer airport_geo_id = template.getForEntity(
                "http://localhost:8081/airport-geo/{country}/{city}",
                Integer.class, UrlValues)
                .getBody();
        //changeToModel(dto, airport);
        airport.setAirportGeoId(airport_geo_id);
        return repo.save(airport);
    }

    public Airport update(Airport airport){
        return repo.save(airport);
    }
    public void deleteByIata(String iata){
        Airport airport = repo.findByIata(iata);
        repo.delete(airport);
    }
    public void deleteById(int airport_id){
        repo.deleteById(airport_id);
    }

    public Airport findByAirportName(String airportName) {
        return repo.findByAirportName(airportName);
    }
}
