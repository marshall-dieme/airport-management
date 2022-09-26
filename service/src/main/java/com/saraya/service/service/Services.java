package com.saraya.service.service;


import com.saraya.service.model.ModelService;
import com.saraya.service.repository.ServiceRepository;
import com.saraya.service.vo.Airport;
import com.saraya.service.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Services {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public ModelService save(ModelService modelService){
        return repository.save(modelService);
    }

    public List<ModelService> findAll(){
        return repository.findAll();
    }

    public ResponseTemplateVo getServiceAirport(long service_id) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        ModelService modelService = repository.findById(service_id);

        Airport airport = restTemplate.getForObject("http://localhost:8082/airport/" +
                modelService.getAirport_id(), Airport.class);
        vo.setAirport(airport);
        vo.setModelService(modelService);
        return vo;
    }

//    //public ModelService findById(long service_id){
//        return repository.findById(service_id);
//    }

    public ModelService update(ModelService modelService){
        return repository.save(modelService);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }


}
