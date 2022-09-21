package com.saraya.Employee.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.Employee.model.Employee;
import com.saraya.Employee.model.EmployeeDto;
import com.saraya.Employee.repository.EmployeeRepository;

@Service
@Transactional

public class EmployeeService {
    private final EmployeeRepository repo;
    
    public EmployeeService(EmployeeRepository repo) { 
		  this.repo = repo; 
		  }
	 
	  public List<Employee> getAll(){
	        return repo.findAll();
	    }

	    public  Employee getByFirstname(String firstname ){
	        return repo.findByFirstname(firstname);
	    }
	   		    
	    public Employee create (EmployeeDto dto){
	    	Employee employee = new Employee();
	        RestTemplate template = new RestTemplate();
	            Map<String , Integer> UrlValues = new HashMap<>();
	        UrlValues.put(("services_name"), dto.getServices_id());
	        Integer service_id = template.getForEntity(
	                "http://localhost:8300/service_airport/{services_name}",
	                Integer.class, UrlValues)
	                .getBody();
	        changeToModel(dto, employee);
	        employee.setServices_id(dto.getServices_id());
	        return repo.save(employee);
	    }

	    public Employee update(EmployeeDto dto){
	    	Employee employee = new Employee();
	        employee.setEmployee_id(dto.getEmployee_id());
	        changeToModel(dto , employee);
	        return repo.save(employee);
	    }

	    public static void changeToModel(EmployeeDto dto , Employee employee){
	        employee.setFirstname(dto.getFirstname());
	        employee.setLastname(dto.getLastname());
	        employee.setBirthdate(dto.getBirthdate());
	        employee.setSex(dto.getSex());
	        employee.setStreet(dto.getStreet());
	        employee.setCity(dto.getCity());
	        employee.setZip(dto.getZip());
	        employee.setCountry(dto.getCountry());
	        employee.setEmail(dto.getEmail());
	        employee.setTelephone(dto.getTelephone());
	        employee.setSalary(dto.getSalary());
	        employee.setUsername(dto.getUsername());
	        employee.setPassword(dto.getPassword());









	    }

	
}
