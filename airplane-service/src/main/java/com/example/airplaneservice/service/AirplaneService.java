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
        urlValues.put("flightNo",dto.getFlightNo());
        urlValues.put("airplaneTypeIdentifier",dto.getAirplaneTypeIdentifier());

        Long idAirline = template.getForEntity("http://localhost:8500/airlines/airlineName/{airline_name}",
                Long.class, urlValues).getBody();

        Long flightId=  template.getForEntity("http://localhost:8903/flights/{flightNo}",
                Long.class, urlValues).getBody();

                Long typeId= template.getForEntity("http://localhost:8907/type/{airplaneTypeIdentifier}",
                Long.class, urlValues).getBody();

        changeToModel(dto, airplane);
        airplane.setIdAirline(idAirline);
        airplane.setFlightId(flightId);
        airplane.setTypeId(typeId);
        return repo.save(airplane);
    }


    private static void changeToModel(AirplaneDto dto, Airplane airplane) {
        airplane.setCapacity(dto.getCapacity());


    }

    public List <Airplane> getAirplanesByAirline(String airlineName) {
        Map<String, String> values = new HashMap<>();
        values.put("airline_name", airlineName);

        RestTemplate template = new RestTemplate();
        Long idAirline = template.getForEntity("http://localhost:8500/airlines/airlineName/{airline_name}",
                Long.class, values).getBody();

        return repo.findByIdAirline(idAirline);
    }

    public List <Airplane> getAirplanesByType(String airplaneTypeIdentifier ) {
        Map<String, String> values = new HashMap<>();
        values.put("airplaneTypeIdentifier", airplaneTypeIdentifier);

        RestTemplate template = new RestTemplate();
        Long typeId = template.getForEntity("http://localhost:8907/type/{airplaneTypeIdentifier}",
                Long.class, values).getBody();

        return repo.findByTypeId(typeId);
    }

    public List <Airplane> getAirplanesByFlight(String flightNo) {
        Map<String, String> values = new HashMap<>();
        values.put("flightNo", flightNo);

        RestTemplate template = new RestTemplate();
        Long flightId = template.getForEntity("http://localhost:8903/flights/{flightNo}",
                Long.class, values).getBody();

        return repo.findByFlightId(flightId);
    }

    public Airplane update(AirplaneDto dto) {
        Airplane airplane = new Airplane();
        airplane.setAirplaneId(dto.getAirplaneId());
        changeToModel(dto, airplane);
        return repo.save(airplane);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }

}
