package com.saraya.airportgeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.airportgeo.dto.AirportGeoDTO;
import com.saraya.airportgeo.services.AirportService;

@RestController
@RequestMapping("/airport-geo")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@GetMapping()
	public String show() {
		return "Hello world";
	}
	@PostMapping("/create")
	public ResponseEntity<AirportGeoDTO> createAirportGeo(@RequestBody AirportGeoDTO airportGeoDTO) {
		airportGeoDTO = airportService.saveAirportGeo(airportGeoDTO);
		ResponseEntity<AirportGeoDTO> entity = new ResponseEntity<>(airportGeoDTO, HttpStatus.CREATED);
		return entity;
	}
	
	@GetMapping("/listOfAirportGeo")
	public ResponseEntity<List<AirportGeoDTO>> getAllAirportGeo() {
		List<AirportGeoDTO> list = airportService.getAll();
		ResponseEntity<List<AirportGeoDTO>> entity = new ResponseEntity<List<AirportGeoDTO>>(list, HttpStatus.OK);
		return entity;
	}
	@GetMapping("/{id}")
	public ResponseEntity<AirportGeoDTO> showAirportGeo(@PathVariable Long id) {
		AirportGeoDTO apgd = airportService.getAiportGeoById(id);
		ResponseEntity<AirportGeoDTO> responseEntity = new ResponseEntity<AirportGeoDTO>(apgd, HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<AirportGeoDTO> updateAirportGeo(@RequestBody AirportGeoDTO airportGeoDTO, @PathVariable Long id) {
		airportGeoDTO = airportService.updateAirportGeo(airportGeoDTO, id);
		ResponseEntity<AirportGeoDTO> responseEntity = new ResponseEntity<AirportGeoDTO>(airportGeoDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAirportGeo(@PathVariable("id") Long airportGeoId) {
		airportService.deleteAirportGeo(airportGeoId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
	
	@GetMapping("/{country}/{city}")
	public Long findByCountryAndCity(@PathVariable String country, @PathVariable String city) {
		return airportService.findByCountryAndCity(country, city).getAirport_geo_id();
	}
}








