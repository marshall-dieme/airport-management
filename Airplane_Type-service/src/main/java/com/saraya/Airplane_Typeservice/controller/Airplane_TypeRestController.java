package com.saraya.Airplane_Typeservice.controller;

import com.saraya.Airplane_Typeservice.dto.AirplaneDto;
import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import com.saraya.Airplane_Typeservice.service.Airplane_TypeService;
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
public class Airplane_TypeRestController {

    private final Airplane_TypeService service;

    @GetMapping
    public ResponseEntity<List<Airplane_Type>> getAllAirplane_Type() {
        return ResponseEntity.ok(service.getAllAirplane_Types());
    }

    @GetMapping("/{airplane_type_id}")
    public ResponseEntity<Airplane_Type> getAirplane_Type(@PathVariable Long airplane_type_id) {
        return ResponseEntity.ok(service.getAirplane_Type(airplane_type_id));
    }

    @PostMapping
    public ResponseEntity<Airplane_Type> saveAirplane_Type(@RequestBody Airplane_Type airplane_type) {
        getAirplaneByRestTemplate(airplane_type);
        return new ResponseEntity<>(service.saveAirplane_Type(airplane_type), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airplane_Type> updateAirplane_Type(@RequestBody Airplane_Type airplane_type) {
        return ResponseEntity.ok(service.updateAirplane_Type(airplane_type));
    }

    @DeleteMapping("/{airplane_type_id}")
    public ResponseEntity<String> deleteAirplane_Type(@PathVariable Long airplane_type_id) {
        service.deleteAirplane_Type(airplane_type_id);
        return ResponseEntity.ok("Airplane_Type "+airplane_type_id+" was deleted successfully");
    }


    public void getAirplaneByRestTemplate(Airplane_Type airplane_type) {
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
