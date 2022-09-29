package com.regulus.flighttimetablerelation.controllers;

import com.regulus.flighttimetablerelation.models.FlightTimeTableRelation;
import com.regulus.flighttimetablerelation.repositories.FLightTimeTableRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flightTimeTable")
public class FlightTimeTableController {

    private final FLightTimeTableRepository repository;

    public FlightTimeTableController(FLightTimeTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{flightId}/{timeTableId}")
    public void create(@PathVariable("flightId") Integer flightId, @PathVariable("timeTableId") Integer timeTableId){
        FlightTimeTableRelation relation = new FlightTimeTableRelation();
        relation.setFlightId(flightId);
        relation.setTimetableId(timeTableId);
        repository.save(relation);
    }

    @GetMapping
    public List<FlightTimeTableRelation> get(){
        return repository.findAll();
    }
}
