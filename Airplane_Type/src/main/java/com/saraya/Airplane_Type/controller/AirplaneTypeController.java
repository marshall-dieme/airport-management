package com.saraya.Airplane_Type.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airplane_Type.dto.AirplaneTypeToAirplaneDTO;
import com.saraya.Airplane_Type.entity.AirplaneType;
import com.saraya.Airplane_Type.service.AirplaneService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/airplaneType")
public class AirplaneTypeController {

    private final AirplaneService airplaneTypeService;

    @PostMapping("/addAirplaneType")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAirplaneType(@RequestBody AirplaneType airplaneType){
        airplaneTypeService.createAirplaneType(airplaneType);
    }

    @GetMapping("/allAirplaneType")
    @ResponseStatus(HttpStatus.OK)
    public List<AirplaneType> getAllAirplaneType(){
        return airplaneTypeService.getALLAirplaneTypes();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    
    public void deleteAirplaneType(@PathVariable Long airplane_type_id){
        airplaneTypeService.deleteAirplaneType(airplane_type_id);
    }

    @GetMapping("/allDto")
    @ResponseStatus(HttpStatus.OK)
    public List<AirplaneTypeToAirplaneDTO> getAllAirplaneTypeToAirplaneDTOs(){
        return airplaneTypeService.getAllAirplaneTypeToAirplaneDTOs();
    }
}