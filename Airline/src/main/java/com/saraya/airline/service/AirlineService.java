package com.saraya.airline.service;


import com.saraya.airline.model.Airline;
import com.saraya.airline.repo.AirlineRepository;
import com.saraya.airline.vo.Airplane;

import com.saraya.airline.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Airline create(Airline airline){
        return repository.save(airline);
    }

    public Airline findAirlineById(long airline_id ){
        return repository.findById(airline_id);
    }

    public ResponseTemplateVo getAirlineWithAirplane(long airline_id) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Airline airline = repository.findById(airline_id);

        Airplane airplane = restTemplate.getForObject("http://localhost:9092/airplane/" +
                airline.getAirplane_id(), Airplane.class);
        vo.setAirplane(airplane);
        vo.setAirline(airline);
        return vo ;

    }
    public List<Airline> findAll(){
        return repository.findAll();
    }

    public Airline update(Airline airline){
        return repository.save(airline);
    }

    public void  delete(long airline_id){
        repository.deleteById(airline_id);
    }



}
