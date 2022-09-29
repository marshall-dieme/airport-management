package com.regulus.employeeservice.services;


import com.regulus.employeeservice.dtos.EmployeeDto;
import com.regulus.employeeservice.models.Employee;
import com.regulus.employeeservice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmployeeService {

    private final RestTemplate restTemplate;
    private final EmployeeRepository repository;

    private final Mapper mapper;

    public EmployeeService(EmployeeRepository repository, Mapper mapper, RestTemplate restTemplate) {
        this.repository = repository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public List<Employee> getEmployee(){
        return repository.findAll();
    }

    public EmployeeDto getEmployee(int id){
        Employee employee =  repository.findById(id).get();
        return mapper.toDto(employee);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = mapper.toEntity(employeeDto);
        employee =  repository.save(employee);
        return mapper.toDto(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id){
        EmployeeDto employeeDto1 = getEmployee(id);
        Employee employee = mapper.toEntity(employeeDto1);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        employee.setBirthDate(LocalDate.parse(employeeDto.getBirthDate(),formatter));
        employee.setSex(employeeDto.getSex());
        employee.setStreet(employeeDto.getStreet());
        employee.setCity(employeeDto.getCity());
        employee.setZip(employeeDto.getZip());
        employee.setCountry(employeeDto.getCountry());
        employee.setEmail(employeeDto.getEmail());
        employee.setTelephone(employeeDto.getTelephone());
        employee.setSalary(employeeDto.getSalary());
        employee.setUserName(employeeDto.getUserName());
        employee.setPassword(employeeDto.getPassword());
        employee = repository.save(employee);
        return mapper.toDto(employee);
    }

    public void deleteEmployee(int id){
        EmployeeDto employeeDto = getEmployee(id);
        Employee employee = mapper.toEntity(employeeDto);
        repository.delete(employee);
    }

    public EmployeeDto createWithRelation(EmployeeDto employeeDto){
        Employee employee = mapper.toEntity(employeeDto);
        Integer serviceId = restTemplate.getForEntity("http://service-service/service/name/" + employeeDto.getService_name(),
                Integer.class)
                .getBody();
        employee = repository.save(employee);
        Map<String, Integer> values = new HashMap<>();
        values.put("empId", employee.getEmployee_id());
        values.put("serviceId", serviceId);
        restTemplate.getForEntity("http://emp-service-relation-service/empServiceRelation/{empId}/{serviceId}",
                Void.class,
                values);
        return mapper.toDto(employee);

    }
}
