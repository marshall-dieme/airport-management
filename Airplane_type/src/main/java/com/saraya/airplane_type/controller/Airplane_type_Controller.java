package com.saraya.airplane_type.controller;


import com.saraya.airplane_type.model.Airplane_type;
import com.saraya.airplane_type.service.Airplane_type_service;
import com.saraya.airplane_type.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane_type")
public class Airplane_type_Controller {

    @Autowired
    private Airplane_type_service service;


    @PostMapping
    public Airplane_type save(@RequestBody Airplane_type airplane_type){
        return service.create(airplane_type);
    }

    @GetMapping
    public List<Airplane_type> getAll(){
        return service.findAll();
    }

    @GetMapping("/{airplane_type_id}")
    public Airplane_type findById(@PathVariable long airplane_type_id){
        return service.findById(airplane_type_id);
    }
     @GetMapping("/airplaneType-airplane/{airplane_type_id}")
     public ResponseTemplateVo getAirplaneTypeWithAirplane(@PathVariable long airplane_type_id){
        return service.getAirplaneTypeWithAirplane(airplane_type_id);
     }

    @PutMapping("")
    public Airplane_type update(@RequestBody Airplane_type airplane_type){
        return service.update(airplane_type);
    }

    @DeleteMapping("/{airplane_type_id}")
    public void delete(@PathVariable long airplane_type_id){
        service.delete(airplane_type_id);
    }

}
