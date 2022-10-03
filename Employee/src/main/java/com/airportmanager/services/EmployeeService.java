package com.airportmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airportmanager.dto.EmployeeToServices;
import com.airportmanager.exception.ResourceNotFindException;
import com.airportmanager.model.Employee;
import com.airportmanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	

	//create employee
	public Employee CreateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	
	public List<Employee>findAllEmployee(){
		return employeeRepo.findAll();
	}
	//Update employee
	public Employee UpdateEmployee(Employee employee) {
		return employeeRepo.save(employee);
		
	}
	//find employee by id
	public Employee  findEmployeeById(Long id) {
	return employeeRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFindException("Employee by id"+id+"Was not Found"));
		
	}
	//delete employee
		public void deleteEmployee(Long id) {
			employeeRepo.deleteById(id);
		}
		//RelationShip Employee Services
		
		
		public List<EmployeeToServices>getAllEmployeeServices(){
			return employeeRepo.findAll()
					.stream()
					.map(this::employeeToservices)
					.collect(Collectors.toList());
		}
		
		private EmployeeToServices employeeToservices(Employee employee) {
			EmployeeToServices ES = new EmployeeToServices();
			ES.setCity(employee.getCity());
			ES.setBirthday(employee.getBirthday());
			ES.setFirstname(employee.getFirstname());
			return ES;
			
		}

}
