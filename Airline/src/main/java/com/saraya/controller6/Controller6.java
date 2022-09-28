package com.saraya.controller6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.dao6.Dao6;
import com.saraya.entit.Airlin;
import com.saraya.exception6.ResourceNotFoundException;
@RestController
@RequestMapping(value="/api/pu")
public class Controller6 {
	@Autowired
    private Dao6 chico;

    @GetMapping("/airline")
    public List<Airlin> getAllService() {
        return chico.findAll();
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<Airlin> getAirlineById(@PathVariable(value = "id") Long airlineid)
        throws ResourceNotFoundException {
        Airlin airplan = chico.findById(airlineid)
          .orElseThrow(() -> new ResourceNotFoundException("Airline not found for this id :: " + airlineid));
        return ResponseEntity.ok().body(airplan);
    }
    
    @PostMapping("/airline")
    public Airlin createService(@Validated @RequestBody Airlin airplan) {
        return chico.save(airplan);
    }

    @PutMapping("/airline/{id}")
    public ResponseEntity<Airlin> updatedAirplan(@PathVariable(value = "id") Long airlineid,
    		@Validated @RequestBody Airlin AirlineDetails) throws ResourceNotFoundException {
        Airlin airplan = chico.findById(airlineid)
        .orElseThrow(() -> new ResourceNotFoundException("Airline not found for this id :: " + airlineid));
         
        airplan.setAirline_name(AirlineDetails.getAirline_name());
        airplan.setIata(AirlineDetails.getIata());

        
        final Airlin updatedAirline = chico.save(airplan);
        return ResponseEntity.ok(updatedAirline);
    }

    @DeleteMapping("/airline/{id}")
    public Map<String, Boolean> deleteAirline(@PathVariable(value = "id") Long airlineid)
         throws ResourceNotFoundException {
        Airlin airplan = chico.findById(airlineid)
       .orElseThrow(() -> new ResourceNotFoundException("Airline not found for this id :: " + airlineid));

        chico.delete(airplan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
