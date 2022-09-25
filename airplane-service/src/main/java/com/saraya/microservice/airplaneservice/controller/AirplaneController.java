package com.saraya.microservice.airplaneservice.controller;



import com.saraya.microservice.airplaneservice.bean.Airplane;
import com.saraya.microservice.airplaneservice.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apn")
public class AirplaneController {
    private final AirplaneService service ;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }


    @GetMapping
    public List<Airplane> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Airplane getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Airplane create(@RequestBody Airplane arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public Airplane update(@RequestBody Airplane arpg) {
        return service.update(arpg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    /*@GetMapping("/country/{country}")
    public AirportGeo getIdDept(@PathVariable String country)
    {
        return service.getIdArp(country);
    }
*/
}
