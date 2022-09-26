package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Service;
import com.saraya.servicesservice.model.ServiceDto;
import com.saraya.servicesservice.repos.Service_Repo;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Transactional
public class ServiceServices {

    private final Service_Repo repo;

    public ServiceServices(Service_Repo repo) {
        this.repo = repo;
    }


    public List<Service> getAll(){
        return repo.findAll();

    }

    public Long getIdService(String serviceName) {
        return repo.getIdServices(serviceName);

    }



    public Service create(ServiceDto dto){
        Service service = new Service();
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("airportName", dto.getAirportName());

        Long airportId = template.getForEntity("http://localhost:8100/airport/airportName/{airportName}",
                Long.class, value).getBody();

        changeToModel(dto, service);
        service.setAirportId(airportId);
        return repo.save(service);
    }

    public Service update(ServiceDto dto){
        Service service = new Service();
        service.setService_id(dto.getServiceId());
        changeToModel(dto, service);
        return repo.save(service);
    }


    public List <Service> getServiceByAirport(String airportName) {
        Map<String, String> values = new HashMap<>();
        values.put("airportName", airportName);

        RestTemplate template = new RestTemplate();
        Long airportId = template.getForEntity("http://localhost:8100/airport/airportName/{airportName}",
                Long.class, values).getBody();

        return repo.findByAirportId(airportId);
    }
    private static void changeToModel(ServiceDto dto, Service service) {
        service.setServiceName(dto.getServiceName());


    }

    public void deleteById(Long service_id ){
        repo.deleteById(service_id);
    }

}
