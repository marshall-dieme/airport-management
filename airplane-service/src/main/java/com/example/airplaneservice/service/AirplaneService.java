package com.example.airplaneservice.service;

import com.example.airplaneservice.model.Airplane;
import com.example.airplaneservice.model.AirplaneDto;
import com.example.airplaneservice.repo.AirplaneRepo;
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



    public List<Airplane> getAll() {
        return repo.findAll();

    }

    public Optional<Airplane> getById(Long id) {
        return repo.findById(id);
    }

   /* public Airplane getByAirplaneName(String name) {
        return repo.findByAirplaneName(name);

    }*/






    public Airplane create(AirplaneDto dto) {
        Airplane airplane= new Airplane();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airline_name", dto.getAirline_name());

        Long idAirline = template.getForEntity("http://localhost:8500/airlines/airlineName/{airline_name}",
                Long.class, urlValues).getBody();
        changeToModel(dto, airplane);
        airplane.setIdAirline(idAirline);
        return repo.save(airplane);
    }


    private static void changeToModel(AirplaneDto dto, Airplane airplane) {
        airplane.setCapacity(dto.getCapacity());


    }

    public Airplane update(AirplaneDto dto) {
        Airplane airplane = new Airplane();
        airplane.setAirplane_id(dto.getAirplane_id());
        changeToModel(dto, airplane);
        return repo.save(airplane);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }

}
