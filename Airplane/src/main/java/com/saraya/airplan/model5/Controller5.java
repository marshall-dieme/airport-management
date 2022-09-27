package com.saraya.airplan.model5;

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

import com.saraya.airplan.dao5.Dao5;
import com.saraya.airplan.entity.Airplan;
import com.saraya.airplan.exception4.ResourceNotFoundException;

@RestController
@RequestMapping(value="/api/pe")
public class Controller5 {

	@Autowired
    private Dao5 chico;

    @GetMapping("/airplanes")
    public List<Airplan> getAllService() {
        return chico.findAll();
    }

    @GetMapping("/airplanes/{id}")
    public ResponseEntity<Airplan> getAirplanById(@PathVariable(value = "id") Long airplaneid)
        throws ResourceNotFoundException {
        Airplan airplan = chico.findById(airplaneid)
          .orElseThrow(() -> new ResourceNotFoundException("Airport not found for this id :: " + airplaneid));
        return ResponseEntity.ok().body(airplan);
    }
    
    @PostMapping("/airplanes")
    public Airplan createService(@Validated @RequestBody Airplan airplan) {
        return chico.save(airplan);
    }

    @PutMapping("/airplane/{id}")
    public ResponseEntity<Airplan> updatedAirplan(@PathVariable(value = "id") Long airpotid,
    		@Validated @RequestBody Airplan AirplanDetails) throws ResourceNotFoundException {
        Airplan airplan = chico.findById(airpotid)
        .orElseThrow(() -> new ResourceNotFoundException("Airplane not found for this id :: " + airpotid));
         
        airplan.setCapacity(AirplanDetails.getCapacity());
        
        
        final Airplan updatedAirplan = chico.save(airplan);
        return ResponseEntity.ok(updatedAirplan);
    }

    @DeleteMapping("/airplanes/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long airplanid)
         throws ResourceNotFoundException {
        Airplan airplan = chico.findById(airplanid)
       .orElseThrow(() -> new ResourceNotFoundException("Airplane not found for this id :: " + airplanid));

        chico.delete(airplan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
