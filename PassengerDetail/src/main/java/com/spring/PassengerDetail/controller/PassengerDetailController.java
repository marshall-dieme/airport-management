package com.spring.PassengerDetail.controller;

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

import com.spring.PassengerDetail.bean.PassengerDetail;
import com.spring.PassengerDetail.service.PassengerDetailService;

@RestController
@RequestMapping("/passengerdetail")
public class PassengerDetailController {
	
	@Autowired

	private  PassengerDetailService service;
	 
	@GetMapping
	public List<PassengerDetail> getAll()
	{
		return service.getAll();
		
	}
	
	@PostMapping
	public PassengerDetail create (@RequestBody PassengerDetail passengerdetail) {
		return service.create(passengerdetail);
	}


 
	@PutMapping("/{id}")

	public PassengerDetail update (@RequestBody PassengerDetail passengerdetail) {
	return service.update(passengerdetail);

	}


	@DeleteMapping("/delete/{id}")

	public void delete(@PathVariable int id) {
	service.delete(id);
	}
}