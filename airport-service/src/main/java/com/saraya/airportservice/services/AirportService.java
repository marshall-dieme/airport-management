package com.saraya.airportservice.services;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDto;
import com.saraya.airportservice.repos.AirportRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    public List<Airport> getAll() {
        return repo.findAll();

    }

    public Optional<Airport> getById(Long id) {
        return repo.findById(id);
    }

   /* public Airport getByAirportName(String name) {
        return repo.findByAirportName(name);

    }*/

    public Long getAirportId(String airport_name){
        return repo.getIdAirport(airport_name);
    }


    public Airport getAirportByAirportGeo(String city,String country) {
        Map<String, String> values = new HashMap<>();
        values.put("city", city);
        values.put("country", country);
        RestTemplate template = new RestTemplate();
        Long idAirportGeo = template.getForEntity("http://localhost:8110/geo/city/country/{city}/{country}",
                Long.class, values).getBody();

        return repo.findByIdAirportGeo(idAirportGeo);
    }




    public Airport create(AirportDto dto) {
        Airport airport= new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("city", dto.getAirportGeoCity());
        urlValues.put("country", dto.getAirportGeoCountry());
        Long idAirportGeo = template.getForEntity("http://localhost:8110/geo/city/country/{city}/{country}",
                Long.class, urlValues).getBody();
        changeToModel(dto, airport);
        airport.setIdAirportGeo(idAirportGeo);
        return repo.save(airport);
    }


    private static void changeToModel(AirportDto dto, Airport airport) {
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirport_name(dto.getAirport_name());

    }

    public Airport update(AirportDto dto) {
        Airport airport = new Airport();
        airport.setId(dto.getId());
        changeToModel(dto, airport);
        return repo.save(airport);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}


