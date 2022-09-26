package com.example.airp.model3;

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

import com.example.airp.dao3.Dao3;
import com.example.airp.entiti3.Airpor;
import com.example.airp.exception3.ResourceNotFoundException;

@RestController
@RequestMapping(value="/api/pp")
public class ControllerAirp {

	@Autowired
    private Dao3 chico;

    @GetMapping("/airports")
    public List<Airpor> getAllService() {
        return chico.findAll();
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Airpor> getEmployeeById(@PathVariable(value = "id") Long airpotid)
        throws ResourceNotFoundException {
        Airpor airpor = chico.findById(airpotid)
          .orElseThrow(() -> new ResourceNotFoundException("Airport not found for this id :: " + airpotid));
        return ResponseEntity.ok().body(airpor);
    }
    
    @PostMapping("/airports")
    public Airpor createService(@Validated @RequestBody Airpor airpor) {
        return chico.save(airpor);
    }

    @PutMapping("/airports/{id}")
    public ResponseEntity<Airpor> updatedAirport(@PathVariable(value = "id") Long airpotid,
    		@Validated @RequestBody Airpor AirportDetails) throws ResourceNotFoundException {
        Airpor airpor = chico.findById(airpotid)
        .orElseThrow(() -> new ResourceNotFoundException("Airport not found for this id :: " + airpotid));
         
        airpor.setIata(AirportDetails.getIata());
        airpor.setIcao(AirportDetails.getIcao());
        airpor.setAirport_name(AirportDetails.getAirport_name());

        
        final Airpor updatedAirport = chico.save(airpor);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/airports/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long airpotid)
         throws ResourceNotFoundException {
        Airpor airpor = chico.findById(airpotid)
       .orElseThrow(() -> new ResourceNotFoundException("Airport not found for this id :: " + airpotid));

        chico.delete(airpor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}



