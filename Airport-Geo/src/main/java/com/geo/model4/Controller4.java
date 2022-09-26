package com.geo.model4;

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

import com.geo.airporgeo.Airport_Geo;
import com.geo.dao4.Dao4;
import com.geo.exception4.ResourceNotFoundException;

@RestController
@RequestMapping(value="/api/po")
public class Controller4 {
	    @Autowired
	    private Dao4 chico;

	    @GetMapping("/airports_geo")
	    public List<Airport_Geo> getAllService() {
	        return chico.findAll();
	    }

	    @GetMapping("/airports_geo/{id}")
	    public ResponseEntity<Airport_Geo> getAirport_GeoById(@PathVariable(value = "id") Long airpot_geoid)
	        throws ResourceNotFoundException {
	        Airport_Geo airpor = chico.findById(airpot_geoid)
	          .orElseThrow(() -> new ResourceNotFoundException("Airport geo not found for this id :: " + airpot_geoid));
	        return ResponseEntity.ok().body(airpor);
	    }
	    
	    @PostMapping("/airports_geo")
	    public Airport_Geo createService(@Validated @RequestBody Airport_Geo airpor) {
	        return chico.save(airpor);
	    }

	    @PutMapping("/airports_geo/{id}")
	    public ResponseEntity<Airport_Geo> updatedAirport(@PathVariable(value = "id") Long airpot_geoid,
	    		@Validated @RequestBody Airport_Geo Airport_geoDetails) throws ResourceNotFoundException {
	        Airport_Geo airpor = chico.findById(airpot_geoid)
	        .orElseThrow(() -> new ResourceNotFoundException("Airport geo not found for this id :: " + airpot_geoid));
	         
	        airpor.setCountry(Airport_geoDetails.getCountry());
	        airpor.setCity(Airport_geoDetails.getCity());

	        
	        final Airport_Geo updatedAirport_Geo = chico.save(airpor);
	        return ResponseEntity.ok(updatedAirport_Geo);
	    }

	    @DeleteMapping("/airports_geo/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long airpot_geoid)
	         throws ResourceNotFoundException {
	        Airport_Geo airpor = chico.findById(airpot_geoid)
	       .orElseThrow(() -> new ResourceNotFoundException("Airport geo not found for this id :: " + airpot_geoid));

	        chico.delete(airpor);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}

