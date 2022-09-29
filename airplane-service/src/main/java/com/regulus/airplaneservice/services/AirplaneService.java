package com.regulus.airplaneservice.services;

import com.regulus.airplaneservice.dtos.AirplaneDto;
import com.regulus.airplaneservice.models.Airplane;
import com.regulus.airplaneservice.repositories.AirplaneRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirplaneService {

    private final AirplaneRepository repository;

    private final RestTemplate restTemplate;
    private final Mapper mapper;

    public AirplaneService(AirplaneRepository repository, RestTemplate restTemplate, Mapper mapper) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<Airplane> getAirplane(){
        return repository.findAll();
    }

    public AirplaneDto getAirplane(int id){
        Airplane airplane =  repository.findById(id).get();
        return mapper.toDto(airplane);
    }

    public AirplaneDto createAirplane(AirplaneDto airplaneDto){
        Integer airline_id = restTemplate.getForEntity("http://airline-service/airline/airlineName/" + airplaneDto.getAirline_name(),
                        Integer.class)
                .getBody();
        assert airline_id != null;
        Integer airplaneType_id = restTemplate.getForEntity("http://airplane-type-service/airplane-type/identifier/" + airplaneDto.getAirplane_type_identifier(),
                Integer.class).getBody();
        assert  airplaneType_id != null;
        Integer flight_id = restTemplate.getForEntity("http://flight-service/flight//flightNo/" + airplaneDto.getFlight_no(),
                Integer.class).getBody();
        assert  flight_id != null;
        airplaneDto.setAirline_id(airline_id);
        airplaneDto.setAirplaneType_id(airplaneType_id);
        airplaneDto.setFlight_id(flight_id);
        Airplane airplane = mapper.toEntity(airplaneDto);
        airplane =  repository.save(airplane);
        return mapper.toDto(airplane);
    }

    public AirplaneDto updateAirplane(AirplaneDto airplaneDto, int id){
        AirplaneDto airplaneDto1 = getAirplane(id);
        Airplane airplane = mapper.toEntity(airplaneDto1);
        airplane.setCapacity(airplaneDto.getCapacity());
        airplane.setAirplane_id(airplaneDto.getAirplane_id());
        airplane.setAirplaneType_id(airplaneDto.getAirplaneType_id());
        airplane.setFlight_id(airplaneDto.getFlight_id());
        airplane = repository.save(airplane);
        return mapper.toDto(airplane);
    }

    public void deleteAirplane(int id){
        AirplaneDto airplaneDto = getAirplane(id);
        Airplane airplane = mapper.toEntity(airplaneDto);
        repository.delete(airplane);
    }

}
