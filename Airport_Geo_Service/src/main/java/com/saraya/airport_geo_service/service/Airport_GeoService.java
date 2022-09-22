package com.saraya.airport_geo_service.service;

import com.saraya.airport_geo_service.model.Airport_Geo;
import com.saraya.airport_geo_service.repos.Airport_geo_Repo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Airport_GeoService {
    private final Airport_geo_Repo repo;


    public Airport_GeoService(Airport_geo_Repo repo) {
        this.repo = repo;
    }
    public List<Airport_Geo> getAll(){ return  repo.findAll();}


    public Long getIdByCountryAndCity( String country , String city){
        return repo.getIdByCountryAndCity(country, city);
    }


    public Airport_Geo create(Airport_Geo ag){ return  repo.save(ag);}

    public Airport_Geo update(Airport_Geo ag){ return  repo.save (ag);}


//    public void deleteByCountryAndCity(String country , String city){
//        Airport_Geo airport_geo = repo.findByCountryAndCity(country , city);
//        repo.delete(airport_geo);
//    }
    public void deleteById(Long airport_geo_id){
        repo.deleteById(airport_geo_id);
    }

//    public Airport_Geo findByCountryAndCity(String country, String city){
//        return repo.findByCountryAndCity(country,city);
//    }
}
