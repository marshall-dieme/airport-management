package com.saraya.employee.controller;

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

import com.saraya.employee.model.EmployeeDTO;
import com.saraya.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	public EmployeeController(EmployeeService employeeService) {
		service = employeeService;
	}
	
	
	@GetMapping
	public List<EmployeeDTO> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return service.create(employeeDTO);
	}
	
	@PutMapping("/update/{id}")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
		return service.update(employeeDTO, id);
	}
	
	@DeleteMapping("/{id}")
		public void deleteEmployee(@PathVariable Long id) {
		service.delete(id);
	}
}
