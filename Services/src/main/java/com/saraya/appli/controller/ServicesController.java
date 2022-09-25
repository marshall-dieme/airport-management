package com.saraya.appli.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.appli.dto.ServicesDTO;
import com.saraya.appli.services.ServicesE;

@RestController
@RequestMapping("/services")
public class ServicesController {
	@Autowired
	private ServicesE services;
	@PostMapping("/createServices")
	public ResponseEntity<ServicesDTO> createServices(@RequestBody ServicesDTO dto){
		return new ResponseEntity<ServicesDTO>(services.createService(dto), HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<ServicesDTO>> retrieveServices(){
		return new ResponseEntity<List<ServicesDTO>>(services.getAllServices(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServicesDTO> showServices(@PathVariable Long id){
		return new ResponseEntity<ServicesDTO>(services.showService(id), HttpStatus.OK);
	}
	@DeleteMapping("/deleteServices/{id}")
	public ResponseEntity<Void> deleteServices(@PathVariable Long id){
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
