package com.airplane.controller;

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

import com.airplane.entities.Airplane;
import com.airplane.service.Airplane_Service;

@RestController
@RequestMapping("/")
public class Airplane_Controller {
	
	@Autowired private Airplane_Service airplane_Service;

	public Airplane_Controller(Airplane_Service airplane_Service) {
		super();
		this.airplane_Service = airplane_Service;
	}
	
	@GetMapping("/")
	public List<Airplane> getAll(){
		return airplane_Service.getAll();
	}
	@GetMapping("/{id}")
	public Airplane getById(@PathVariable long id) {
		return airplane_Service.getById(id);
	}
	@PostMapping("/")
	public Airplane create(@RequestBody Airplane airplane) {
		return airplane_Service.create(airplane);
	}
	@PutMapping("/")
	public Airplane update(@RequestBody Airplane airplane) {
		return airplane_Service.update(airplane);
	}
	@DeleteMapping("/")
	public void delete(@PathVariable long id) {
		airplane_Service.delete(id);
	}
	
}
