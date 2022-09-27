package com.saraya.Airportservice.service;


import com.saraya.Airportservice.bean.ResponseAirportAndDetails;
import com.saraya.Airportservice.dto.*;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.model.Mapper;
import com.saraya.Airportservice.proxies.AirlineProxy;
import com.saraya.Airportservice.proxies.Airport_GeoProxy;
import com.saraya.Airportservice.proxies.ServicesProxy;
import com.saraya.Airportservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class AirportService {

    private final AirportRepository repository;

    private final AirlineProxy airlineProxy;
    private final Airport_GeoProxy airport_geoProxy;
    private final ServicesProxy servicesProxy;
    private final Mapper mapper;


    public List<AirportDto> getAllAirports() {
        return repository.findAll().stream().map(mapper::convertToDto).toList();
    }

    public AirportDto getAirport(Long airport_id) {
        Airport airport = repository.findById(airport_id).orElse(null);
        return airport != null ? mapper.convertToDto(airport): null;
    }

    public Airport saveAirport(AirportDto dto) {
        airlineProxy.getAirline(dto.getAirline_id());
        airport_geoProxy.getAirportGeo(dto.getAirport_geo_id());
        servicesProxy.getService(dto.getServices_id());
        return repository.save(mapper.convertToEntity(dto));
    }

    public Airport updateAirport(AirportDto dto) {
        return repository.save(mapper.convertToEntity(dto));
    }

    public void deleteAirport(Long airport_id) {
        repository.deleteById(airport_id);
    }


    public List<ResponseAirportAndDetails> getAllAirportsWithDetails() {
        List<ResponseAirportAndDetails> details = new ArrayList<>();
        List<AirportDto> airportDtos = repository.findAll().stream().map(mapper::convertToDto).toList();
        for (AirportDto dto: airportDtos) {
            ResponseAirportAndDetails allDetails = getAirportWithAllDetails(mapper.convertToEntity(dto).getAirport_id());
            details.add(allDetails);
        }
        return details;
    }


    public ResponseAirportAndDetails getAirportWithAllDetails(Long airport_id) {
        ResponseAirportAndDetails details = new ResponseAirportAndDetails();
        Airport airport = repository.findByAirport_id(airport_id);

        details.setAirport(airport);
        details.setAirport_geo(airport_geoProxy.getAirportGeo(airport.getAirport_geo_id()));
        details.setServices(servicesProxy.getService(airport.getServices_id()));
        details.setAirline(airlineProxy.getAirline(airport.getAirline_id()));

        return details;
    }

}
