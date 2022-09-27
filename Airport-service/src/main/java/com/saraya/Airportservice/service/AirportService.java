package com.saraya.Airportservice.service;

import com.saraya.Airportservice.dto.*;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.model.Mapper;
import com.saraya.Airportservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
@Transactional
public class AirportService {

    private final AirportRepository repository;

    private final RestTemplate restTemplate;

    private final Mapper map;


    public List<AirportDto> getAllAirports() {
        return repository.findAll().stream().map(map::convertToDto).toList();
    }

    public AirportDto getAirport(Long airport_id) {
        return map.convertToDto(repository.findById(airport_id).orElse(new Airport()));
    }

    public Airport saveAirport(AirportDto dto) {
        return repository.save(map.convertToEntity(dto));
    }

    public Airport updateAirport(AirportDto dto) {
        return repository.save(map.convertToEntity(dto));
    }

    public void deleteAirport(Long airport_id) {
        repository.deleteById(airport_id);
    }

/*    public void getServiceByRestTemplate(AirportDto airportDto) {
        Map<String,String>  service_value = new HashMap<>();
        service_value.put("service_name", airportDto.getService_name());
        Services services = new RestTemplate()
                .getForEntity("http://localhost:8082/services/service-name/{service_name}",
                        Services.class, service_value).getBody();
        System.out.println(services);
        Airport airport = map.convertToEntity(airportDto);
        if (services != null) {
            airport.setService_id(services.getServices_id());
        }
    }
    public void getDetailsByRestTemplate(AirportDto airportDto) {
        Map<String,String> airport_value = new HashMap<>();
        airport_value.put("country", airportDto.getAirport_geo_country());
        airport_value.put("city", airportDto.getAirport_geo_city());
        Airport_Geo dto = new RestTemplate()
                .getForEntity("http://localhost:8080/airports-geo/{country}/{city}",
                        Airport_Geo.class, airport_value).getBody();
        System.out.println(dto);
        Airport airport = map.convertToEntity(airportDto);
        if (dto != null) {
            airport.setAirport_geo_id(dto.getAirport_geo_id());
        }
    }

    public void getAirlineByRestTemplate(AirportDto airportDto) {
        Map<String,String>  airline_value = new HashMap<>();
        airline_value.put("airline_name", airportDto.getAirline_name());
        Airline airline = new RestTemplate()
                .getForEntity("http://localhost:8084/airlines/airline-name/{airline_name}",
                        Airline.class, airline_value).getBody();
        System.out.println(airline);
        Airport airport = map.convertToEntity(airportDto);
        if (airline != null) {
            airport.setAirline_id(airline.getAirline_id());
        }
    }*/

    public ResponseTemplateValueObject getAirportWithAllDetails(Long airport_id) {
        ResponseTemplateValueObject valueObject = new ResponseTemplateValueObject();

        Airport airport = repository.findByAirline_id(airport_id);

        Airport_Geo airport_geo = restTemplate.getForObject(
                "http://localhost:8080/airports-geo/" +airport.getAirport_geo_id(),
                Airport_Geo.class);
        Airline airline = restTemplate.getForObject(
                "http://localhost:8084/airlines/"+ airport.getAirline_id(),
                Airline.class);

        Services services = restTemplate.getForObject(
                "http://localhost:8082/services/"+ airport.getService_id(),
                Services.class);

        valueObject.setAirport_geo(airport_geo);
        valueObject.setAirline(airline);
        valueObject.setServices(services);
        return valueObject;
    }
}
