package com.airport_geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport_geo.entities.Airport_Geo;
import com.airport_geo.service.Airport_Geo_Service;

@RestController
@RequestMapping("/")
public class Airport_Geo_Controller {
	
	@Autowired Airport_Geo_Service airport_Geo_Service;

	public Airport_Geo_Controller(Airport_Geo_Service airport_Geo_Service) {
		super();
		this.airport_Geo_Service = airport_Geo_Service;
	}
	@GetMapping("/")
	public List<Airport_Geo> getAll(){
		return airport_Geo_Service.getAll();
	}
	@GetMapping("/{id}")
	public Airport_Geo getById(@PathVariable long id) {
		return airport_Geo_Service.getById(id);
	}
	@PostMapping("/")
	public Airport_Geo create(@RequestBody Airport_Geo airport_Geo) {
		return airport_Geo_Service.create(airport_Geo);
	}
	@PutMapping("/")
	public Airport_Geo update(@RequestBody Airport_Geo airport_Geo) {
		return airport_Geo_Service.update(airport_Geo);
	}
	@DeleteMapping("/")
	public void delete(@PathVariable long id) {
		airport_Geo_Service.delete(id);
	}

}
