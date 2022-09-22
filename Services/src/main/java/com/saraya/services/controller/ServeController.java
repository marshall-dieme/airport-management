package com.saraya.services.controller;

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

import com.saraya.services.dto.ServiceDTO;
import com.saraya.services.serviceI.Services;

@RestController
@RequestMapping("/services")
public class ServeController {
	@Autowired
	private Services services;
	
	@PostMapping("/create")
	public ResponseEntity<ServiceDTO> createServices(@RequestBody ServiceDTO dto) {
		dto = services.createService(dto);
		ResponseEntity<ServiceDTO> responseEntity = new ResponseEntity<ServiceDTO>(dto, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/services-list")
	public ResponseEntity<List<ServiceDTO>> retreiveService() {
		List<ServiceDTO> slist = services.getAllServices();
		ResponseEntity<List<ServiceDTO>> responseEntity = new ResponseEntity<List<ServiceDTO>>(slist, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServiceDTO> showService(@PathVariable Long id) {
		ServiceDTO dto = services.showService(id);
		ResponseEntity<ServiceDTO> responseEntity = new ResponseEntity<ServiceDTO>(dto, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PutMapping("/updateServices/{id}")
	public ResponseEntity<ServiceDTO> showService(@RequestBody ServiceDTO dto, @PathVariable Long id) {
		 dto = services.updateServices(dto, id);
		ResponseEntity<ServiceDTO> responseEntity = new ResponseEntity<ServiceDTO>(dto, HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	@DeleteMapping("/deleteServices")
	public ResponseEntity<Void> deleteServices(@PathVariable Long id) {
		services.delete(id);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
	
	
	
}















