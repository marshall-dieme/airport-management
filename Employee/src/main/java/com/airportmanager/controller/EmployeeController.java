package com.airportmanager.controller;

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

import com.airportmanager.dto.EmployeeToServices;
import com.airportmanager.model.Employee;
import com.airportmanager.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	//All Employees
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>>getAllEmployee(){
		List<Employee>employee= employeeService.findAllEmployee();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") Long id){
		Employee employee=employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
	//create
			@PostMapping("/Create")
	public ResponseEntity<Employee>CreateEmployee(@RequestBody Employee employee){
				Employee newEmployee=employeeService.CreateEmployee(employee);
				return new ResponseEntity<>( newEmployee,HttpStatus.CREATED);
			}
			
			@PutMapping("/Update")
			public ResponseEntity<Employee >UpdateEmployee (@RequestBody Employee  employee ){
				Employee  UpdateEmployee =employeeService.UpdateEmployee (employee);
				return new ResponseEntity<>(UpdateEmployee ,HttpStatus.OK);
			}
			
			@DeleteMapping("/Delete{id}")
			public ResponseEntity<Employee>DeleteEmployee(@PathVariable("id") Long id){
				employeeService.deleteEmployee(id);
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
//			
			
			//get All ServiceToAirport
			@GetMapping("/serviceToairport")
			public List<EmployeeToServices> getAllEmployeeServices(){
				return employeeService.getAllEmployeeServices();
		    }
	
		
	}


