package com.airplane_type.controller;

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

import com.airplane_type.entities.Airplane_Type;
import com.airplane_type.service.Airplane_Type_Service;

@RestController
@RequestMapping("/")
public class Airplane_Type_Controller {
	@Autowired
	private Airplane_Type_Service airplane_Type_Service;

	public Airplane_Type_Controller(Airplane_Type_Service airplane_Type_Service) {
		super();
		this.airplane_Type_Service = airplane_Type_Service;
	}
	@GetMapping("/")
	public List<Airplane_Type> getAll(){
		return airplane_Type_Service.getAll();
	}
	@GetMapping("/{id}")
	public Airplane_Type getById(@PathVariable long id) {
		return airplane_Type_Service.getById(id);
	}
	@PostMapping("/")
	public Airplane_Type create(@RequestBody Airplane_Type airplane_Type) {
		return airplane_Type_Service.create(airplane_Type);
	}
	@PutMapping("/")
	public Airplane_Type update(@RequestBody Airplane_Type airplane_Type) {
		return airplane_Type_Service.update(airplane_Type);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
	}
	
}
