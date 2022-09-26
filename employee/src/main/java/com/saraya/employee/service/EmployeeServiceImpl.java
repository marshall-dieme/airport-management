package com.saraya.employee.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.employee.model.Employee;
import com.saraya.employee.model.EmployeeDTO;
import com.saraya.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired
	EmployeeRepo repo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		repo = employeeRepo;
	}
	@Override
	public List<EmployeeDTO> getAll(){
		
		List<Employee> employee = (List<Employee>) repo.findAll();
		List<EmployeeDTO> employeeDTO = new ArrayList<>();
		
		for(Employee emp: employee) {
			EmployeeDTO dto = empToDto(emp);
			employeeDTO.add(dto);
		}
		return employeeDTO;
	}
	@Override
	public EmployeeDTO getById(Long id) {
		
		Optional<Employee> result = repo.findById(id);
		Employee employee = null;
		if(result.isPresent()) {
			 employee = result.get();
		}
		else {
			throw new RuntimeException("Didn't find employee with id " +id);
		}
		EmployeeDTO employeeDTO = empToDto(employee);
		return employeeDTO; 
	}
	
	@Override
	public EmployeeDTO create(EmployeeDTO dto) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Employee employee = new Employee();
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
		employee.setBirthdate(birthdate);
		employee.setEmail(dto.getEmail());
		employee.setStreet(dto.getStreet());
		employee.setSex(dto.getSex());
		employee.setUsername(dto.getUsername());
		employee.setCountry(dto.getCountry());
		employee.setCity(dto.getCity());
		employee.setZip(dto.getZip());
		employee.setSalary(dto.getSalary());
		employee.setPassword(dto.getPassword());
		employee.setTelephone(dto.getTelephone());
		employeeDTO = empToDto(employee);
		repo.save(employee);
		return employeeDTO;
	}
	
	@Override
	public EmployeeDTO update(EmployeeDTO dto, Long id) {
		// TODO Auto-generated method stub
		EmployeeDTO employeeDTO = null;
		Optional<Employee> result = repo.findById(id);
		if(result.isPresent()) {
			Employee employee = result.get();
			employee.setFirstName(dto.getFirstName());
			employee.setLastName(dto.getLastName());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
			employee.setBirthdate(birthdate);
			employee.setEmail(dto.getEmail());
			employee.setStreet(dto.getStreet());
			employee.setSex(dto.getSex());
			employee.setUsername(dto.getUsername());
			employee.setCountry(dto.getCountry());
			employee.setCity(dto.getCity());
			employee.setZip(dto.getZip());
			employee.setSalary(dto.getSalary());
			employee.setPassword(dto.getPassword());
			employee.setTelephone(dto.getTelephone());
			employeeDTO = empToDto(employee);
		}
		return employeeDTO;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public Employee dtoToEmp(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
		employee.setEmail(dto.getEmail());
		employee.setBirthdate(birthdate);
		employee.setStreet(dto.getStreet());
		employee.setSex(dto.getSex());
		employee.setUsername(dto.getUsername());
		employee.setCountry(dto.getCountry());
		employee.setCity(dto.getCity());
		employee.setZip(dto.getZip());
		employee.setSalary(dto.getSalary());
		employee.setPassword(dto.getPassword());
		employee.setTelephone(dto.getTelephone());
		return employee;
	}
	
	private EmployeeDTO empToDto(Employee employee) {
		EmployeeDTO dto =new EmployeeDTO();
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setBirthdate(employee.getBirthdate().toString());
		dto.setEmail(employee.getEmail());
		dto.setStreet(employee.getStreet());
		dto.setSex(employee.getSex());
		dto.setUsername(employee.getUsername());
		dto.setCountry(employee.getCountry());
		dto.setCity(employee.getCity());
		dto.setZip(employee.getZip());
		dto.setSalary(employee.getSalary());
		dto.setPassword(employee.getPassword());
		dto.setTelephone(employee.getTelephone());
		return dto;
	}

	

	
	
}
