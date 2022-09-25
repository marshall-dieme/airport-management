package com.microservices.airline.Passager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airline.Passager.entity.Passager;
import com.microservices.airline.Passager.service.PassagerService;

@RestController
@RequestMapping("/passager")
public class PassagerController {
	
	private final PassagerService service;

	public PassagerController(PassagerService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<Passager> getAll() {
		return service.getPassager();
	}
	
	
	@GetMapping("/{passagerid}")
	public Optional<Passager> getById(@PathVariable String passagerid) {
		return service.getByid(passagerid);
	}
	
	
	@DeleteMapping("/{passagerid}")
	public void delete(@PathVariable String passagerid) {
			service.delete(passagerid);
	}
	
	
	@PostMapping
	public Passager create( @RequestBody Passager passager) {
		return service.create(passager);
	}
	
	
	@PutMapping
	public Passager update(@RequestBody Passager passager) {
		return service.update(passager);
	}

	
	
	@GetMapping("/passportNo/{passportno}")
	public  String getByPassportno(@PathVariable String passportno) {
		return service.getByPassportno(passportno);
	}
	
	
	
	
	
	
	
}
