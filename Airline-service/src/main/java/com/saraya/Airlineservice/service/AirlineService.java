package com.saraya.Airlineservice.service;

import com.saraya.Airlineservice.bean.ResponseAirlineWithAirplanes;
import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.proxies.AirplaneProxy;
import com.saraya.Airlineservice.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AirlineService {

    private final AirlineRepository repository;

    private final AirplaneProxy airplaneProxy;


    public List<Airline> getAllAirlines() {
        return repository.findAll();
    }

    public Airline getAirline(Long airline_id) {
        return repository.findById(airline_id).orElse(new Airline());


    }public Airline getAirlineByName(String airline_name) {
        return repository.getAirlineByAirline_name(airline_name);
    }

    public Airline saveAirline(Airline airline) {
        return repository.save(airline);
    }

    public Airline updateAirline(Airline airline) {
        return repository.save(airline);
    }

    public void deleteAirline(Long airline_id) {
        repository.deleteById(airline_id);
    }

    public ResponseAirlineWithAirplanes getAirlineWithAirplanes(Long airline_id) {
        ResponseAirlineWithAirplanes airlineWithAirplanes = new ResponseAirlineWithAirplanes();
        Airline airline = repository.findAirlineByAirline_id(airline_id);

        airlineWithAirplanes.setAirline(airline);
        airlineWithAirplanes.setAirplane(airplaneProxy.getAirplane(airline.getAirplane_id()));

        return airlineWithAirplanes;
    }

    public List<ResponseAirlineWithAirplanes> getAllAirlineWithAirplanes() {
        List<ResponseAirlineWithAirplanes> airlineWithAirplanes = new ArrayList<>();
        List<Airline> airlines = repository.findAll();
        for (Airline airline: airlines) {
            ResponseAirlineWithAirplanes responseAirlineWithAirplanes = getAirlineWithAirplanes(airline.getAirline_id());
            airlineWithAirplanes.add(responseAirlineWithAirplanes);
        }
        return airlineWithAirplanes;
    }
}
