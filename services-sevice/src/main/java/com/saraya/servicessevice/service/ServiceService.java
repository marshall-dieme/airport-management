package com.saraya.servicessevice.service;

import com.saraya.servicessevice.dto.ServiceDto;
import com.saraya.servicessevice.bean.Services;
import com.saraya.servicessevice.mapper.ServiceMapper;
import com.saraya.servicessevice.repo.ServiceRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceService {

    private final ServiceRepo repo;

    public ServiceService(ServiceRepo repo) {
        this.repo = repo;
    }

    ServiceMapper mapper = new ServiceMapper();

    public int getIdServiceByName(String name){
        return repo.findByName(name).getServiceId();
    }

    public Services creat(ServiceDto dto){
        return repo.save(mapper.toEntity(dto));
    }

    public List<Services> getAll(){
        return repo.findAll();
    }

    public Services putAirportForService(int serviceId, String airportName) {
        Services services = repo.findById(serviceId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airportId = restTemplate.getForEntity("http://localhost:8004/Airport/"+airportName,
                Integer.class).getBody();

        services.setAirportId(airportId);
        return repo.save(services);
    }

    public String putEmployeeForService(int serviceId, String employeeUsername) {

        RestTemplate restTemplate = new RestTemplate();
        int employeeId = restTemplate.getForEntity("http://localhost:8008/Employee/"+employeeUsername,
                Integer.class).getBody();

        Map<String, Integer> urlValues = new HashMap<>();
        urlValues.put("employeeId", employeeId);
        urlValues.put("serviceId", serviceId);
        new RestTemplate().getForEntity("http://localhost:8024/Relation/{employeeId}/{serviceId}", void.class, urlValues).getBody();

        return "add succefull";
    }

    public List<Integer> getListEmployee() {
        return new RestTemplate().getForEntity("http://localhost:8024/Relation/employeeId", List.class).getBody();
    }

    public Services update(ServiceDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public void delete(ServiceDto dto) {
        repo.delete(mapper.toEntity(dto));
    }
}
