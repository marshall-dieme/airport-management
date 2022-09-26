package com.saraya.services.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.services.model.Services;
import com.saraya.services.model.ServicesDTO;
import com.saraya.services.repository.ServicesRepository;

@Service

public class ServicesserviceImpl implements Servicesservice {
	
	@Autowired
	private ModelMapper modelmap;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private  ServicesRepository repo;
	
	public ServicesserviceImpl(ServicesRepository servicesRepo) {
		repo = servicesRepo;
	}
	@Override
	public List<ServicesDTO> getAll() {
		
		// TODO Auto-generated method stub
		List<Services> services = (List<Services>)repo.findAll();
		List<ServicesDTO> servicesDTO = new ArrayList<>();
		
		for(Services se : services) {
			ServicesDTO dto = convertToDto(se);
			servicesDTO.add(dto);
		}
		return servicesDTO;
	}

	@Override
	public ServicesDTO getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Services> result = repo.findById(id);
		Services services = null;
		if(result.isPresent()) {
			services = result.get();
		}
		else {
			throw new RuntimeException("Didn't find Services with id " +id);
		}
		ServicesDTO servicesDTO = convertToDto(services);
		return servicesDTO;
	}

	@Override
	public Services create(ServicesDTO dto) {
		// TODO Auto-generated method stub
		Services services = new Services();
		Map<String,String> value = new HashMap<>();
		value.put("airportName", dto.getAirportName());
		Long airportId = template.getForEntity("http://localhost:8400/airport/name/{airportName}",
				Long.class, value).getBody();
		services = changeToModel(dto);
		services.setAirportId(airportId);		
		return repo.save(services);
	}
	@Override
	 public List <Services> getServicesByAirport(String airportName) {
        Map<String, String> value = new HashMap<>();
        value.put("airport_name", airportName);
        Long airportId = template.getForEntity("http://localhost:8400/airport/{airportName}",
                Long.class, value).getBody();

        return repo.findByAirportId(airportId);
    }

	@Override
	public ServicesDTO update(ServicesDTO dto, Long id) {
		// TODO Auto-generated method stub
		ServicesDTO servicesDTO = null;
		Optional<Services> result = repo.findById(id);
		if(result.isPresent()) {
			Services services = result.get();
			services.setServiceName(dto.getServiceName());
			servicesDTO = convertToDto(services);
			services = repo.save(services);
		}
		return servicesDTO;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
			repo.deleteById(id);
	}

	public Services changeToModel(ServicesDTO dto) {
		Services services = modelmap.map(dto, Services.class);
		return services;
	}
	private ServicesDTO convertToDto(Services services) {
		ServicesDTO dto = modelmap.map(services, ServicesDTO.class);
		return dto;
	}
}
