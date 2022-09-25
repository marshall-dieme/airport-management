package com.saraya.airplanetypeservice.service;

import com.saraya.airplanetypeservice.bean.AirplaneType;
import com.saraya.airplanetypeservice.dto.AirplaneTypeDto;
import com.saraya.airplanetypeservice.repository.AirplaneTypeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirplaneTypeService {

    private final AirplaneTypeRepo repo;

    public AirplaneTypeService(AirplaneTypeRepo repo) {
        this.repo = repo;
    }

    public List<AirplaneType> getAll() {
        return repo.findAll();
    }

    public AirplaneType create(AirplaneTypeDto dto) {
        return repo.save(toEntity(dto));
    }

    private AirplaneType toEntity(AirplaneTypeDto dto) {
        AirplaneType airplaneType = new AirplaneType();
        airplaneType.setAirplaneTypeIdentifier(dto.getAirplaneTypeIdentifier());
        airplaneType.setDescription(dto.getDescription());
        return airplaneType;
    }

    public int getId(String identifier) {
        return repo.findByAirplaneTypeIdentifier(identifier).getId();
    }

    public AirplaneType putAirplaneForAirplaneType(int airplaneTypeId, int airplaneCapacity) {
        AirplaneType airplaneType = repo.findById(airplaneTypeId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airpplaneId = restTemplate.getForEntity("http://localhost:8002/Airplane/"+airplaneCapacity, Integer.class).getBody();
        airplaneType.getAirplaneId().add(airpplaneId);

        return repo.save(airplaneType);
    }
}
