package com.saraya.service.controller;

import com.saraya.service.dto.ServiceDto;
import com.saraya.service.model.ModelService;
import com.saraya.service.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ControllerService {

    @Autowired
    private Services services;

    @PostMapping("/")
    public ServiceDto create(@RequestBody ServiceDto serviceDto){
        return services.save(serviceDto);
    }


    @GetMapping("/")
    public List<ModelService> getAll(){
        return services.findAll();
    }

    @GetMapping("/{service_id}")
    public ServiceDto  getServiceId(@PathVariable long service_id ){
        return services.getServiceById(service_id);
    }

//    @GetMapping("/name/{service_name}")
//    public String  getServiceName(@PathVariable String service_name ){
//        return services.getServiceName(service_name);
//    }

    @PutMapping("/{service_id}")
    public ServiceDto  update(@RequestBody ServiceDto serviceDto, @PathVariable("service_id") long service_id){
        return services.update(serviceDto, service_id);
    }

    @DeleteMapping("/{service_id}")
    public void delete(@PathVariable long service_id){
        services.deleteById(service_id);
    }

    
}
