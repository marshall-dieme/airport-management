package com.saraya.Airplane_Typeservice.controller;

import com.saraya.Airplane_Typeservice.consumer.AirplaneConsumer;
import com.saraya.Airplane_Typeservice.consumer.ResponseAirplaneAndAirplaneType;
import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import com.saraya.Airplane_Typeservice.service.Airplane_TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airplane-types")
@RestController
public class Airplane_TypeRestController {

    private final Airplane_TypeService service;

    private final AirplaneConsumer airplaneConsumer;

    @GetMapping
    public ResponseEntity<List<Airplane_Type>> getAllAirplane_Type() {
        return ResponseEntity.ok(service.getAllAirplane_Types());
    }

    @GetMapping("/parking-passenger/all")
    public ResponseEntity<List<ResponseAirplaneAndAirplaneType>> getAllAirplane_TypesWithPassengers() {
        return ResponseEntity.ok(service.getAllAirplane_TypesWithPassengers());
    }


    @GetMapping("/parking-passenger/{airplane_type_id}")
    public ResponseEntity<ResponseAirplaneAndAirplaneType> getAirplane_TypeWithPassenger(@PathVariable Long airplane_type_id) {
        return ResponseEntity.ok(service.getAirplane_TypeWithPassenger(airplane_type_id));
    }

    @GetMapping("/{airplane_type_id}")
    public ResponseEntity<Airplane_Type> getAirplane_Type(@PathVariable Long airplane_type_id) {
        return ResponseEntity.ok(service.getAirplane_Type(airplane_type_id));
    }

    @PostMapping
    public ResponseEntity<Airplane_Type> saveAirplane_Type(@RequestBody Airplane_Type airplane_type) {
        return new ResponseEntity<>(service.saveAirplane_Type(airplane_type), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airplane_Type> updateAirplane_Type(@RequestBody Airplane_Type airplane_type) {
        airplaneConsumer.getAirplane(airplane_type.getAirplane_id());
        return ResponseEntity.ok(service.updateAirplane_Type(airplane_type));
    }

    @DeleteMapping("/{airplane_type_id}")
    public ResponseEntity<String> deleteAirplane_Type(@PathVariable Long airplane_type_id) {
        service.deleteAirplane_Type(airplane_type_id);
        return ResponseEntity.ok("Airplane_Type "+airplane_type_id+" was deleted successfully");
    }

}
