 package com.saraya.employee.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.employee.dto.EmployeeDTO;
import com.saraya.employee.mapper.ConvertEmployee;
import com.saraya.employee.model.Employee;
import com.saraya.employee.repository.EmployeeRepository;
import com.saraya.employee.services.EmployeeServices;
@Service
public class EmployeeServiceImpl implements EmployeeServices {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired 
	private ConvertEmployee convertEmployee;
	@Override
	public EmployeeDTO creatEmployee(EmployeeDTO dto) {
		Employee employee = convertEmployee.toEmployee(dto);
		employeeRepository.save(employee);
		EmployeeDTO employeeDTO = convertEmployee.todto(employee);
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> dtos = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeeDTO dto = convertEmployee.todto(employee);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public EmployeeDTO getEmploye(Long employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		EmployeeDTO dto = null;
		if(optional.isPresent()) {
			Employee employee = optional.get();
			dto = convertEmployee.todto(employee);
		}
		else {
			throw new RuntimeException("verify the id that you want to show!!!!!!");
		}
		return dto;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		EmployeeDTO dto = null;
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employee.setCity(employeeDTO.getCity());
			employee.setBirthdate(LocalDate.parse(employeeDTO.getBirthdate()));
			employee.setCountry(employeeDTO.getCountry());
			employee.setEmail(employeeDTO.getEmail());
			employee.setFirstname(employeeDTO.getFirstname());
			employee.setLastname(employeeDTO.getLastname());
			employee.setPassword(employeeDTO.getPassword());
			employee.setSalary(employeeDTO.getSalary());
			employee.setSex(employeeDTO.getSex());
			employee.setStreet(employeeDTO.getStreet());
			employee.setTelephone(employeeDTO.getTelephone());
			employee.setUsername(employeeDTO.getUsername());
			employee.setZip(employeeDTO.getZip());
			dto = convertEmployee.todto(employee);
			employeeRepository.save(employee);
		}
		return dto;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
