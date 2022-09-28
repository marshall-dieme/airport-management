package com.airport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.entities.Airport;
import com.airport.service.Airport_Service;

@RestController
@RequestMapping("/")
public class Airport_Controller {
	@Autowired
	private Airport_Service airport_Service;

	public Airport_Controller(Airport_Service airport_Service) {
		super();
		this.airport_Service = airport_Service;
	}
	@GetMapping("/")
	public List<Airport> getAll(){
		return airport_Service.getAll();
	}
	@GetMapping("/{id}")
	public Airport getById(@PathVariable long id) {
		return airport_Service.getById(id);
	}
	@PostMapping("/")
	public Airport create(@RequestBody Airport airport) {
		return airport_Service.create(airport);
	}
	@PutMapping("/")
	public Airport update(@RequestBody Airport airport) {
		return airport_Service.update(airport);
	}
	@DeleteMapping("/")
	public void delete(@PathVariable long id) {
		airport_Service.delete(id);
	}

}
