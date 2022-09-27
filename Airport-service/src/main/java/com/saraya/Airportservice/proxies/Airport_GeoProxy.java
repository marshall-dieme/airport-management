package com.saraya.Airportservice.proxies;

import com.saraya.Airportservice.bean.Airport_Geo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "airport-geo-service", url = "http://localhost:8080/airports-geo")
public interface Airport_GeoProxy {

    @GetMapping
    List<Airport_Geo> getAllAirportGeo();

    @GetMapping("/{airport_geo_id}")
    Airport_Geo getAirportGeo(@PathVariable Long airport_geo_id);

    @PostMapping
    Airport_Geo saveAirport_Geo(@RequestBody Airport_Geo airport_geo);

    @PutMapping
    Airport_Geo updateAirport_Geo(@RequestBody Airport_Geo airport_geo);

    @DeleteMapping("/{airport_geo_id}")
    String deleteAirport_Geo(@PathVariable Long airport_geo_id);


    @GetMapping("/{country}/{city}")
    ResponseEntity<Airport_Geo> getAirport_GeoByCountryAndCity(
            @PathVariable String country, @PathVariable String city);
}
