package com.saraya.airplane.service;

import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.model.AirplaneDto;
import com.saraya.airplane.repo.AirplaneRepo;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Transactional
public class AirplaneService {

    private final AirplaneRepo repo;

    public AirplaneService(AirplaneRepo repo) {
        this.repo = repo;
    }

    public List<Airplane> getAll(){
        return repo.findAll();

    }

    public Long getIdAirplane(String airplane) {
        return repo.getIdAirplane(airplane);

    }



    public Airplane create(AirplaneDto dto){
        Airplane airplane = new Airplane();
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("airlineName", dto.getAirlineName());

        Long IdAirline = template.getForEntity("http://localhost:8400/airline/airlineName/{airlineName}",
                Long.class, value).getBody();

        changeToModel(dto, airplane);
        airplane.setIdAirline(IdAirline);
        return repo.save(airplane);
    }

    public Airplane update(AirplaneDto dto){
        Airplane airplane = new Airplane();
        airplane.setAirplane_id(dto.getAirplane_id());
        changeToModel(dto, airplane);
        return repo.save(airplane);
    }


    public List <Airplane> getAirplaneByAirline(String airlineName) {
        Map<String, String> values = new HashMap<>();
        values.put("airlineName", airlineName);

        RestTemplate template = new RestTemplate();
        Long IdAirline = template.getForEntity("http://localhost:8400/airline/airlineName/{airlineName}",
                Long.class, values).getBody();

        return repo.findByIdAirline(IdAirline);
    }
    private static void changeToModel(AirplaneDto dto, Airplane airplane) {
        airplane.setCapacity(dto.getCapacity());


    }

    public void deleteById(Long airplane_id ){
        repo.deleteById(airplane_id);
    }
}
