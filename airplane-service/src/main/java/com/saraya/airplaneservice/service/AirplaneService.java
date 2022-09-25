package com.saraya.airplaneservice.service;

import com.saraya.airplaneservice.bean.Airplane;
import com.saraya.airplaneservice.dto.AirplaneDto;
import com.saraya.airplaneservice.repository.AirplaneRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirplaneService {
    private final AirplaneRepo repo;

    public AirplaneService(AirplaneRepo repo) {
        this.repo = repo;
    }

    public List<Airplane> getAll() {
        return repo.findAll();
    }

    public Airplane create(AirplaneDto dto) {
        return repo.save(toEntity(dto));
    }

    private Airplane toEntity(AirplaneDto dto) {
        Airplane airplane = new Airplane();
        airplane.setCapacity(dto.getCapacity());
        return airplane;
    }

    public Airplane putAirlineForAirplane(int airplaneId, String airlineName) {

        Airplane airplane = repo.findById(airplaneId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airlineId = restTemplate.getForEntity("http://localhost:8001/Airline/"+airlineName,
                Integer.class).getBody();

        airplane.setAirlineId(airlineId);
        return repo.save(airplane);
    }

    public int getIdByCapacity(int capacity) {
        return repo.getByCapacity(capacity).getId();
    }

    public Airplane putAirPlaneTypeForAirplane(int airplaneId, String identifierAirplaneType) {

        Airplane airplane = repo.findById(airplaneId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airplaneTypeId = restTemplate.getForEntity("http://localhost:8003/AirplaneType/"+identifierAirplaneType,
                Integer.class).getBody();

        airplane.setAirplaneTypeId(airplaneTypeId);
        return repo.save(airplane);
    }
}
