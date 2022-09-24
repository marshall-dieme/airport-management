package com.saraya.airport.service;

import com.saraya.airport.Dto.AirportGeoDto;
import com.saraya.airport.model.Airport;
import com.saraya.airport.Dto.AirportDto;
import com.saraya.airport.repository.AirportRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Airportservice extends com.saraya.airport.model.Airport {
    private final ModelMapper modelMapper;
    private final AirportRepo repo;

    public Airportservice(ModelMapper modelMapper, AirportRepo repo) {
        this.modelMapper = modelMapper;
        this.repo = repo;
    }

    public List<Airport> getAll() {
        return repo.findAll();
    }

    public Airport create(AirportDto dto) {
        GetAirportGeo(dto);
        return repo.save(modelMapper.map(dto, Airport.class));
    }

    public Airport getAirport(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Airport update(Airport airport) {
        return repo.save(airport);
    }

    public void GetAirportGeo(AirportDto dto){
        Map<String, String> values = new HashMap<>();
        values.put("country",dto.getCountry());
        values.put("city",dto.getCity());
        AirportGeoDto airportGeoDto = new RestTemplate()
                .getForEntity("http://localhost:8083/Airport_Geo/{country}/{city}",
                        AirportGeoDto.class,values ).getBody();
        Airport airport = modelMapper.map(dto,Airport.class);
        if (airportGeoDto != null){
            airport.setAirportgeoId(airportGeoDto.getAirport_geo_id());
        }
    }

}
