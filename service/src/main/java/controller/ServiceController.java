package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Services;
import service.ServiceServices;

@RestController
public class ServiceController {
	private final ServiceServices service;

	public ServiceController(ServiceServices service) {
		
		this.service = service;
	}
	
	@GetMapping("/")
	public List<Services>getAll(){
		return service.getAll();
	}
	@GetMapping("/{services_name}")
	public Services getByName(@PathVariable String services_name) {
		return service.getBYName(services_name);
	}
	@PostMapping("/")
	public Services create(@RequestBody Services services ) {
		return service.create(services);
	}
	@PutMapping("/")
	public Services update(@RequestBody Services services) {
		return service.update(services);
	}
	@DeleteMapping("/{services_id}")
	public void delete(@PathVariable long services_id ) {
	service.deleteById(services_id);
	}
	
	@DeleteMapping("/")
	public void delete(@RequestBody Services services) {
	service.delete(services);
	}
	

}
