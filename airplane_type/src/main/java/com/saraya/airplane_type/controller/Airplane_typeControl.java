package com.saraya.airplane_type.controller;

import com.saraya.airplane_type.dtos.AirplaneDto;
import com.saraya.airplane_type.model.Airplane_type;
import com.saraya.airplane_type.service.Airplane_typeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("airplane-types")
@RestController
public class Airplane_typeControl {
    private final Airplane_typeService service;

    @GetMapping
    public ResponseEntity<List<Airplane_type>> getAllAirplane_Type() {
        return ResponseEntity.ok(service.getAllAirplane_Types());
    }

    @GetMapping("/{airplane_type_id}")
    public ResponseEntity<Airplane_type> getAirplane_Type(@PathVariable Long airplane_type_id) {
        return ResponseEntity.ok(service.getAirplane_Type(airplane_type_id));
    }

    @PostMapping
    public ResponseEntity<Airplane_type> saveAirplane_Type(@RequestBody Airplane_type airplane_type) {
        getAirplaneByRestTemplate(airplane_type);
        return new ResponseEntity<>(service.saveAirplane_type(airplane_type), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airplane_type> updateAirplane_Type(@RequestBody Airplane_type airplane_type) {
        return ResponseEntity.ok(service.updateAirplane_type(airplane_type));
    }

    @DeleteMapping("/{airplane_type_id}")
    public ResponseEntity<String> deleteAirplane_Type(@PathVariable Long airplane_type_id) {
        service.deleteAirplane_type(airplane_type_id);
        return ResponseEntity.ok("Airplane_Type "+airplane_type_id+" was deleted successfully");
    }


    public void getAirplaneByRestTemplate(Airplane_type airplane_type) {
        Map<String, Long> airplane_value = new HashMap<>();
        airplane_value.put("airplane_id", airplane_type.getAirplane_id());
        AirplaneDto airplaneDto = new RestTemplate()
                .getForEntity("http://localhost:8085/airplanes/{airplane_id}",
                        AirplaneDto.class, airplane_value).getBody();
        if (airplaneDto != null) {
            airplane_type.setAirplane_id(airplaneDto.getAirplane_id());
        }
    }
}
