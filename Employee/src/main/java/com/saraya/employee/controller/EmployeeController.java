package com.saraya.employee.controller;

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

import com.saraya.employee.dto.EmployeeDTO;
import com.saraya.employee.services.EmployeeServices;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
	@Autowired
	private EmployeeServices services;
	
	@GetMapping("/created")
	public String createEmployee() {
		return "Helle";
	}
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeDTO = services.creatEmployee(employeeDTO);
		ResponseEntity<EmployeeDTO> responseEntity = new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping()
	private List<EmployeeDTO> retrieveEmployees() {
		return services.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	private EmployeeDTO showEmployees(@PathVariable Long id) {
		EmployeeDTO dto = services.getEmploye(id);
		return dto;
	}
	
	@PutMapping("/update/{id}")
	private EmployeeDTO updateEmployees(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
		EmployeeDTO dto = services.updateEmployee(employeeDTO, id);
		return dto;
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleteEmployees(@PathVariable Long id) {
		services.deleteEmployee(id);
	}
}







