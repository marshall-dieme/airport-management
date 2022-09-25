package com.saraya.microservice.airplane_typeservice.controller;




import com.saraya.microservice.airplane_typeservice.bean.AirplaneType;
import com.saraya.microservice.airplane_typeservice.service.AirplaneTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apnt")
public class AirplaneTypeController {
    private final AirplaneTypeService service ;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }


    @GetMapping
    public List<AirplaneType> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AirplaneType getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public AirplaneType create(@RequestBody AirplaneType arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public AirplaneType update(@RequestBody AirplaneType arpg) {
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
