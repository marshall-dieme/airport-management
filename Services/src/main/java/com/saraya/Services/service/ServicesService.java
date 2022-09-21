package com.saraya.Services.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.saraya.Services.model.Services_airport;
import com.saraya.Services.model.Services_airportDto;
import com.saraya.Services.repository.ServicesRepo;


@Service
@Transactional
public class ServicesService {
	 private final ServicesRepo repo;

		
	  public  ServicesService (ServicesRepo repo) { 
		  this.repo = repo; 
		  }
	 
	  public List<Services_airport> getAll(){
	        return repo.findAll();
	    }

	    public  Services_airport getByServices_name(String services_name){
	        return repo.findByServices_name(services_name);
	    }

	    public Services_airport create (Services_airportDto dto){
	    	Services_airport service = new Services_airport();
	        RestTemplate template = new RestTemplate();
	            Map<String , Integer> UrlValues = new HashMap<>();
	        UrlValues.put((" iata"), dto.getAirport_id());
	        Integer airport_id = template.getForEntity(
	                "http://localhost:8200/airport/{iata}",
	                Integer.class, UrlValues)
	                .getBody();
	        UrlValues.put((" firstname"), dto.getEmployee_id());
	        Integer employee_id = template.getForEntity(
	                "http://localhost:8400/employee/{firstname}",
	                Integer.class, UrlValues)
	                .getBody();
	        changeToModel(dto, service);
	        service.setAirport_id(dto.getAirport_id());
	        service.setEmployee_id(dto.getEmployee_id());
	        return repo.save(service);
	    }

	    public Services_airport update(Services_airportDto dto){
	    	Services_airport service = new Services_airport();
	    	service.setAirport_id(dto.getAirport_id());
	        changeToModel(dto , service);
	        return repo.save(service);
	    }

	    public static void changeToModel(Services_airportDto dto , Services_airport service){
	        service.setServices_name(dto.getServices_name());
	        service.setAirport_id(dto.getAirport_id());
	        service.setEmployee_id(dto.getEmployee_id());
	    }
}
