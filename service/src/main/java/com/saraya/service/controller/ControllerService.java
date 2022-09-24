package com.saraya.service.controller;

import com.saraya.service.model.ModelService;
import com.saraya.service.service.Services;
import com.saraya.service.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ControllerService {

    @Autowired
    private Services services;

    @PostMapping("/")
    public ModelService create(@RequestBody ModelService modelService){
        return services.save(modelService);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getServiceAirport(@PathVariable("id") long service_id ){
        return services.getServiceAirport(service_id);
    }

    @GetMapping("/")
    public List<ModelService> getAll(){
        return services.findAll();
    }

    @PutMapping("/")
    public ModelService update(@RequestBody ModelService modelService){
        return services.update(modelService);
    }

    @DeleteMapping("/{service_id}")
    public void delete(@PathVariable long service_id){
        services.deleteById(service_id);
    }

    
}
