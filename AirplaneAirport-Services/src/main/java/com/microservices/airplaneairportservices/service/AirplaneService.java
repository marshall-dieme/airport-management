package com.microservices.airplaneairportservices.service;


import com.microservices.airplaneairportservices.entity.Airplane;
import com.microservices.airplaneairportservices.entity.AirplaneDTO;
import com.microservices.airplaneairportservices.repository.AirplaneRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AirplaneService {

    private final AirplaneRepo repo;

    public AirplaneService(AirplaneRepo repo) {
        this.repo = repo;
    }

    public List<Airplane> getAll(){
        return repo.findAll();
    }

    public Optional<Airplane> getById(Long airplane_id) {
        return repo.findById(airplane_id);
    }

    public Airplane create(AirplaneDTO dto) {
        Airplane airplane = new Airplane();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airlineName", dto.getAirlineName());
        String idAirline = template.getForEntity(
                        "http://localhost:8003/airline/airlineName/{airlineName}",
                        String.class,
                        urlValues)
                .getBody();
        changeToModel(dto, airplane);
        airplane.setIdAirline(idAirline);
        return repo.save(airplane);
    }

    public Airplane update(AirplaneDTO dto) {
        Airplane airplane = new Airplane();
        airplane.setAirplane_id(dto.getAirplane_id());
        changeToModel(dto, airplane);
        return repo.save(airplane);
    }

    private static void changeToModel(AirplaneDTO dto, Airplane airplane) {
        airplane.setCapacity(dto.getCapacity());

    }

    public void delete(Long airplane_id) {
        repo.deleteById(airplane_id);
    }

    public List<Airplane> findAirlineByAirplane(String airlineName){
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airlineName", airlineName);
        String idAirline = template.getForEntity(
                        "http://localhost:8003/airline/airlineName/{airlineName}",
                        String.class,
                        urlValues)
                .getBody();

        return (List<Airplane>)
                repo.findByIdAirline(idAirline);
    }


}
