package com.saraya.Airportservice.service;

import com.saraya.Airportservice.dto.AirlineDto;
import com.saraya.Airportservice.dto.AirportDto;
import com.saraya.Airportservice.dto.Airport_GeoDto;
import com.saraya.Airportservice.dto.ServicesDto;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.model.Mapper;
import com.saraya.Airportservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private final Mapper map;


    public List<AirportDto> getAllAirports() {
        return repository.findAll().stream().map(map::convertToDto).toList();
    }

    public AirportDto getAirport(Long airport_id) {
        return map.convertToDto(repository.findById(airport_id).orElse(new Airport()));
    }

    public Airport saveAirport(AirportDto dto) {
        getDetailsByRestTemplate(dto);
        getServiceByRestTemplate(dto);
        getAirlineByRestTemplate(dto);
        return repository.save(map.convertToEntity(dto));
    }

    public Airport updateAirport(AirportDto dto) {
        getDetailsByRestTemplate(dto);
        getServiceByRestTemplate(dto);
        getAirlineByRestTemplate(dto);
        return repository.save(map.convertToEntity(dto));
    }

    public void deleteAirport(Long airport_id) {
        repository.deleteById(airport_id);
    }

    public void getServiceByRestTemplate(AirportDto airportDto) {
        Map<String,String>  service_value = new HashMap<>();
        service_value.put("service_name", airportDto.getService_name());
        ServicesDto servicesDto = new RestTemplate()
                .getForEntity("http://localhost:8082/services/service-name/{service_name}",
                        ServicesDto.class, service_value).getBody();
        System.out.println(servicesDto);
        Airport airport = map.convertToEntity(airportDto);
        if (servicesDto != null) {
            airport.setService_id(servicesDto.getServices_id());
        }
    }
    public void getDetailsByRestTemplate(AirportDto airportDto) {
        Map<String,String> airport_value = new HashMap<>();
        airport_value.put("country", airportDto.getAirport_geo_country());
        airport_value.put("city", airportDto.getAirport_geo_city());
        Airport_GeoDto dto = new RestTemplate()
                .getForEntity("http://localhost:8080/airports-geo/{country}/{city}",
                        Airport_GeoDto.class, airport_value).getBody();
        System.out.println(dto);
        Airport airport = map.convertToEntity(airportDto);
        if (dto != null) {
            airport.setAirport_geo_id(dto.getAirport_geo_id());
        }
    }

    public void getAirlineByRestTemplate(AirportDto airportDto) {
        Map<String,String>  airline_value = new HashMap<>();
        airline_value.put("airline_name", airportDto.getAirline_name());
        AirlineDto airlineDto = new RestTemplate()
                .getForEntity("http://localhost:8084/airlines/airline-name/{airline_name}",
                        AirlineDto.class, airline_value).getBody();
        System.out.println(airlineDto);
        Airport airport = map.convertToEntity(airportDto);
        if (airlineDto != null) {
            airport.setAirline_id(airlineDto.getAirline_id());
        }
    }

}
