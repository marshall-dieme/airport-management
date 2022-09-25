package com.saraya.microservice.passengerDetailservice.controller;

import com.saraya.microservice.passengerDetailservice.bean.PassagerDetail;
import com.saraya.microservice.passengerDetailservice.bean.PassagerDetailDto;
import com.saraya.microservice.passengerDetailservice.service.PassagerDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasd")
public class PassagerDController {
    private final PassagerDetailService service ;


    public PassagerDController(PassagerDetailService service) {
        this.service = service;
    }


    @GetMapping
    public List<PassagerDetail> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PassagerDetail getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public PassagerDetail create(@RequestBody PassagerDetailDto arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public PassagerDetail update(@RequestBody PassagerDetailDto arpg) {
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
