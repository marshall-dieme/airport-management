package com.saraya.passengerdetailsservice.controller;

import com.saraya.passengerdetailsservice.model.Detail;
import com.saraya.passengerdetailsservice.model.DetailDto;
import com.saraya.passengerdetailsservice.service.DetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailController {
    private final DetailService service;

    public DetailController(DetailService service) {
        this.service = service;
    }


    @GetMapping
    public List<Detail> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Detail> getById(@PathVariable Long passengerDetailId) {
        return service.getById(passengerDetailId);
    }


    @GetMapping("/passportNo/{passportNo}")
    public Detail getdetailByPassenger(@PathVariable String passportNo) {
        return service.getDetailByPassenger(passportNo);
    }



    @PostMapping
    public Detail create(@RequestBody DetailDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Detail update(@RequestBody DetailDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
