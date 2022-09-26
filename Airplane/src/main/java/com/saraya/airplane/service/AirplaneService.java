package com.saraya.airplane.service;

import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.repo.AirplaneRepository;
import com.saraya.airplane.vo.Airline;
import com.saraya.airplane.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository repository;


    @Autowired
    private RestTemplate restTemplate;

    public Airplane create(Airplane airplane){
        return repository.save(airplane);
    }

    public ResponseTemplateVo getAirplaneWithAirline(long airplane_id) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Airplane airplane = repository.findById(airplane_id);

        Airline airline = restTemplate.getForObject("http://localhost:9091/airline/" +
                airplane.getAirline_id(), Airline.class);
        vo.setAirplane(airplane);
        vo.setAirline(airline);
        return vo;

    }
    public List<Airplane> findAll(){
        return repository.findAll();
    }

    public Airplane update(Airplane airplane){
        return repository.save(airplane);
    }

    public void deleteById(long airplane_id){
        repository.deleteById(airplane_id);
    }


}
