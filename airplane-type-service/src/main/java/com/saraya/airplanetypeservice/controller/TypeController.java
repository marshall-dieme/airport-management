package com.saraya.airplanetypeservice.controller;

import com.saraya.airplanetypeservice.model.Type;
import com.saraya.airplanetypeservice.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    private final TypeService service;

    public TypeController(TypeService servicce) {
        this.service = servicce;
    }



    @GetMapping
    public List<Type> getAll(){
        return service.getAll();
    }


    @GetMapping("/{airplaneTypeIdentifier}")
    public Long getIdType(@PathVariable String airplaneTypeIdentifier){
        return service.getTypeId(airplaneTypeIdentifier);
    }


    @PostMapping("/")
    public Type create(@RequestBody Type type) {

        return service.create(type);
    }

    @PutMapping("/")
    public Type update (@RequestBody Type type){
        return service.update(type);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
