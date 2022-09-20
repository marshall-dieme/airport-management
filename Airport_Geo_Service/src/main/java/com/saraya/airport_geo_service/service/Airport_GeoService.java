package com.saraya.airport_geo_service.service;

import com.saraya.airport_geo_service.model.Airport_Geo;
import com.saraya.airport_geo_service.repos.Airport_geo_Repo;
import org.springframework.stereotype.Service;

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

    public Airport_Geo getById(Long airport_geo_id){
        return  repo.findById(airport_geo_id).get();
    }


    public Airport_Geo create(Airport_Geo ag){ return  repo.save(ag);}

    public Airport_Geo update(Airport_Geo ag){ return  repo.save (ag);}


    public void deleteByName(Long airport_geo_id) {
       // Airport_Geo ag = repo.findById( airport_geo_id);
        repo.deleteById(airport_geo_id);
    }
    public void delete(Long airport_geo_id){
        repo.deleteById(airport_geo_id);
    }
}
