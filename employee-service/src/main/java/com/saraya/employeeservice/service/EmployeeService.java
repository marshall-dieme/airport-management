package com.saraya.employeeservice.service;

import com.saraya.employeeservice.dto.ResponseTemplateDto;
import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.dto.EmployeeDTO;
import com.saraya.employeeservice.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;


    private RestTemplate restTemplate;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Optional<Employee> getById(Long emp_id){
        return repo.findById(emp_id);
    }

    public  Employee create(EmployeeDTO dto){
        Employee employee = new Employee();
        return repo.save(employee);
    }

    public Employee update(Employee employee){
        return repo.save(employee);
    }

    public void delete(Long emp_id){
        repo.deleteById(emp_id);
    }

    public ResponseTemplateDto getEmployeeWithService(Long emp_id) {
        ResponseTemplateDto dto=new ResponseTemplateDto();
        Employee employee= repo.findByEmployeeid(emp_id);


        Service service=
                restTemplate.getForObject( "http://localhost:8500/employee-service/" +
                employee.getEmp_id(), Service.class);
                dto.setEmployee(employee);
                dto.setServices(service);
        return dto;
    }
    }



