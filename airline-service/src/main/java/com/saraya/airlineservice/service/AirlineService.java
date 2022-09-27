package com.saraya.airlineservice.service;

import com.saraya.airlineservice.bean.Airline;
import com.saraya.airlineservice.dto.AirlineDto;
import com.saraya.airlineservice.mapper.AirlineMapper;
import com.saraya.airlineservice.reository.AirlineRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepo repo;

    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    AirlineMapper mapper = new AirlineMapper();

    public Airline create(AirlineDto dto){
        return repo.save(mapper.toEntity(dto));
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }

    public Airline putAirportForAirline(int airlineId, String airportName){
        Airline airline = repo.findById(airlineId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airportId = restTemplate.getForEntity("http://localhost:8004/Airport/"+airportName,
                Integer.class).getBody();

        airline.setAirportId(airportId);
        return repo.save(airline);
    }

    public int getIdAirlineByName(String nameAirline) {
        return repo.getAirlineByAirlineName(nameAirline).getId();
    }

    public Airline putAirplaneForAirline(int airlineId, int airplaneCapacity) {

        Airline airline = repo.findById(airlineId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airpplaneId = restTemplate.getForEntity("http://localhost:8002/Airplane/"+airplaneCapacity, Integer.class).getBody();
        airline.getAirplaneId().add(airpplaneId);

        return repo.save(airline);
    }

    public Airline update(AirlineDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public void delete(AirlineDto dto) {
        repo.delete(mapper.toEntity(dto));
    }

}
