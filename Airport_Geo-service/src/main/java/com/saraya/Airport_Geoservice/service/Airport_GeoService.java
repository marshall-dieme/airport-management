package com.saraya.Airport_Geoservice.service;

import com.saraya.Airport_Geoservice.model.Airport_Geo;
import com.saraya.Airport_Geoservice.repository.Airport_GeoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class Airport_GeoService {

    private final Airport_GeoRepository repository;

    public List<Airport_Geo> getAllAirportGeo() {
        return repository.findAll();
    }

    public Airport_Geo getAirportGeo(Long id) {
        log.info("Get Airport Geo {}", id);
        return repository.findById(id).orElse(new Airport_Geo());
    }

    public Airport_Geo saveAirportGeo(Airport_Geo airport_geo) {
        log.info("New Airport Geo has been added: {}", airport_geo);
        return repository.save(airport_geo);
    }

    public Airport_Geo updateAirportGeo(Airport_Geo airport_geo) {
        log.info("Airport Geo {} has been updated: {}",airport_geo.getAirport_geo_id(), airport_geo);
        return repository.save(airport_geo);
    }

    public void deleteAirport_Geo(Long airport_geo_id) {
        log.info("Airport Geo {} has been deleted", airport_geo_id);
        repository.deleteById(airport_geo_id);
    }

}
