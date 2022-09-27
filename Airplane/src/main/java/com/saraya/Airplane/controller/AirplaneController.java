package com.saraya.Airplane.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airplane.dto.AirplaneToAirline;
import com.saraya.Airplane.dto.AirplaneToAirplaneType;
import com.saraya.Airplane.dto.AirplaneToFlight;
import com.saraya.Airplane.entity.Airplane;
import com.saraya.Airplane.service.AirplaneService;

import lombok.AllArgsConstructor;

 
@AllArgsConstructor
@RestController
@RequestMapping("/airplaneType")
public class AirplaneController {
    
    private final AirplaneService airplaneService;

    @PostMapping("/addAirplane")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAirplaneType(@RequestBody Airplane airplane){
        airplaneService.createAirplane(airplane);
    }

    @GetMapping("/allAirplane")
    @ResponseStatus(HttpStatus.OK)
    public List<Airplane> getAllAirplaneType(){
        return airplaneService.getAllAirplanes();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    
    public void deleteAirplaneType(@PathVariable Long airplane_id){
        airplaneService.deleteAirplane(airplane_id);
    }

    
    @GetMapping("/allAirplanetoFlight")
    @ResponseStatus(HttpStatus.OK)
    public List<AirplaneToFlight> getAllAirplaneToFlightDTOs(){
        return airplaneService.getAllAirplaneToFlight();
    }

     
    @GetMapping("/allAirplanetoAirline")
    @ResponseStatus(HttpStatus.OK)
    public List<AirplaneToAirline> getAllAirplaneToAirlineDTOs(){
        return airplaneService.getAllAirplaneToAirlineDTOs();
    }

    @GetMapping("/allAirplanetoAirplaneType")
    @ResponseStatus(HttpStatus.OK)
    public List<AirplaneToAirplaneType> getAllAirplanetoAirplaneTypeDTOs(){
        return airplaneService.getAirplaneToAirplaneType();
    }



    

}