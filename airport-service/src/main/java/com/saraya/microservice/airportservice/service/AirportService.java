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

    public Airport getById(int id) {
        return repo.findById(id).get();
    }

    public Airport create(AirportDto dto) {
        Airport a = new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("name", dto.getArp());
        String idarg = template.getForEntity(
                "http://localhost:8700/arp/country/{coutry}",
                String.class,
                urlValues)
                .getBody();
        changeToModel(dto, a);
       a.setId(idarg);
    //setAirport_geo_id(airport_geo_id);
        return repo.save(a);

    }

    private static void changeToModel(AirportDto dto, Airport a) {
        a.setIata(dto.getIata());
        a.setIcao(dto.getIcao());
        a.getAirport_name(dto.getAirport_name());
    }

    public Airport update(AirportDto dto) {
        Airport a = new Airport();
        a.setAirport_id(dto.getAirport_id());
            changeToModel(dto, a);
            return repo.save(a);

    }

    public void delete(int id) {
        repo.deleteById(id);
    }


    /*public Airport getIdArp(String airport_name) {
        return repo.findAirportByAirport_name(airport_name);
    }*/
}
