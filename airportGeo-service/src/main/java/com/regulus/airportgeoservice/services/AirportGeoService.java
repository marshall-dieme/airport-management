package com.regulus.airportgeoservice.services;

import com.regulus.airportgeoservice.DTO.AirportGeoDto;
import com.regulus.airportgeoservice.models.AirportGeo;
import com.regulus.airportgeoservice.repositories.AirportGeoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportGeoService {

    private final AirportGeoRepository repository;

    private final Mapper mapper;

    public AirportGeoService(AirportGeoRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AirportGeo> getAirportGeo(){
        return repository.findAll();
    }

    public AirportGeoDto getAirportGeo(int id){
        AirportGeo airportGeo =  repository.findById(id).get();
        return mapper.toDto(airportGeo);
    }

    public Integer getAirportGeo(String city, String country){
        return repository.findByCityAndCountry(city, country);
    }

    public AirportGeoDto createAirportGeo(AirportGeoDto airportGeoDto){
        AirportGeo airportGeo = mapper.toEntity(airportGeoDto);
         airportGeo =  repository.save(airportGeo);
         return mapper.toDto(airportGeo);
    }


    public AirportGeoDto updateAirportGeo(AirportGeoDto airportGeoDto, int id){
        AirportGeoDto airportGeoDto1 = getAirportGeo(id);
        AirportGeo airportGeo = mapper.toEntity(airportGeoDto1);
        airportGeo.setCountry(airportGeoDto.getCountry());
        airportGeo.setCity(airportGeoDto.getCity());
        airportGeo = repository.save(airportGeo);
        return mapper.toDto(airportGeo);
    }

    public void deleteAirportGeo(int id){
        AirportGeoDto airportGeoDto = getAirportGeo(id);
        AirportGeo airportGeo = mapper.toEntity(airportGeoDto);
        repository.delete(airportGeo);
    }
}
