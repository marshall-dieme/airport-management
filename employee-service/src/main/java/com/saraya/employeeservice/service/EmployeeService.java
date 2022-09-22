package com.saraya.employeeservice.service;

import com.saraya.employeeservice.bean.Employee;
import com.saraya.employeeservice.bean.EmployeeDto;
import com.saraya.employeeservice.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee create(EmployeeDto dto){
        Employee employee = toEntity(dto);

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("name", dto.getService());

        String serviceId = restTemplate.getForEntity("http://localhost:8007/Services/{name}", String.class,
                urlValues).getBody();
        System.out.println();
        repo.save(employee);

        Map<String, Integer> urlValues1 = new HashMap<>();
        urlValues1.put("empId", employee.getId());
        urlValues1.put("servId", Integer.valueOf(serviceId));

        new RestTemplate().getForEntity("http://localhost:8024/Relation/{empId}/{servId}", void.class,
                urlValues1).getBody();

        return employee;
    }

    public Employee toEntity(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        return employee;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
}
