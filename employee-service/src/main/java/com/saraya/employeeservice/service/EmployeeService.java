package com.saraya.employeeservice.service;

import com.saraya.employeeservice.bean.Employee;
import com.saraya.employeeservice.dto.EmployeeDto;
import com.saraya.employeeservice.mapper.EmployeeMapper;
import com.saraya.employeeservice.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    EmployeeMapper mapper = new EmployeeMapper();

    public Employee create(EmployeeDto dto){
        return repo.save(mapper.toEntity(dto));
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public int getIdEmpByUsername(String username) {
        System.out.println(repo.findByUsername(username).getId());
        return repo.findByUsername(username).getId();
    }

    public String putServiceForEmployee(int employeeId, String serviceName) {
        RestTemplate restTemplate = new RestTemplate();
        int serviceId = restTemplate.getForEntity("http://localhost:8007/Services/"+serviceName, Integer.class).getBody();

        Map<String, Integer> urlValues1 = new HashMap<>();
        urlValues1.put("employeeId", employeeId);
        urlValues1.put("serviceId", serviceId);

        new RestTemplate().getForEntity("http://localhost:8024/Relation/{employeeId}/{serviceId}", void.class,
                urlValues1).getBody();
    return "add succefull";
    }

    public List<Integer> getListServiceId() {
        return new RestTemplate().getForEntity("http://localhost:8024/Relation/serviceId", List.class).getBody();
    }

    public Employee update(EmployeeDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public void delete(EmployeeDto dto) {
        repo.delete(mapper.toEntity(dto));
    }
}
