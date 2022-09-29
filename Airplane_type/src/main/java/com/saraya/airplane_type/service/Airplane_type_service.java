package com.saraya.airplane_type.service;


import com.saraya.airplane_type.model.Airplane_type;
import com.saraya.airplane_type.repo.Airplane_type_repository;
import com.saraya.airplane_type.vo.Airplane;
import com.saraya.airplane_type.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Airplane_type_service {

    @Autowired
    private Airplane_type_repository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Airplane_type create(Airplane_type airplane_type){
        return repository.save(airplane_type);
    }

    public List<Airplane_type> findAll(){
        return repository.findAll();
    }

    public  Airplane_type findById(long airplane_type_id){
        return repository.findById(airplane_type_id);
    }

    public ResponseTemplateVo getAirplaneTypeWithAirplane(long airplane_type_id){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Airplane_type airplane_type = repository.findById(airplane_type_id);

        Airplane airplane = restTemplate.getForObject("http://localhost:9092/airplane/" +
                airplane_type.getAirplane_id(), Airplane.class);
        vo.setAirplane(airplane);
        vo.setAirplane_type(airplane_type);
        return vo;
    }
    public Airplane_type update(Airplane_type airplane_type){
        return repository.save(airplane_type);
    }

    public void delete(long airplane_type_id){
        repository.deleteById(airplane_type_id);
    }


}
