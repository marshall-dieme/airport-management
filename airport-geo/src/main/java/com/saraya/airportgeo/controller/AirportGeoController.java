package com.saraya.airportgeo.controller;

import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.service.AirportGeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport-geo")
//@SLF4j
public class AirportGeoController {

    //pour debugger
    private final Logger LOGGER = LoggerFactory.getLogger(AirportGeoController.class);

    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<AirportGeo> getAll(@RequestParam(defaultValue = "10") int page,
                                   @RequestParam(defaultValue = "20") int nbre){
        return service.getAllPaginated(page, nbre);
    }

    @GetMapping("/recup/{country}/{city}")
    public AirportGeo getByCountryAndCity(
            @PathVariable String country , @PathVariable String city){
        return service.getByCountryAndCity(country, city);
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeo airportGeo){
        LOGGER.info("CREATING A NEW AIRPORT GEO...");
        return service.create(airportGeo);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeo airportGeo){
        LOGGER.info("Update Airport Geo....");
        return service.update(airportGeo);
    }

    @DeleteMapping("delete/{country}/{city}")
    public void deleteByCountryAndCity(
            @PathVariable String country , @PathVariable String city){
        service.deleteByCountryAndCity(country, city);
    }

    @DeleteMapping("/{airport_geo_id}")
    public void deleteById(@PathVariable int airportGeoId){
        service.deleteById(airportGeoId);
    }


    @GetMapping("/{country}/{city}")
    public Integer findByCountryAndCity(
            @PathVariable String country , @PathVariable String city) {
        return  service.findByCountryAndCity(country , city).getAirportGeoId();
    }
}
