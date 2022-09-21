package com.saraya.airportservice.service;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.repo.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportService {
    @Autowired
    private  final AirportRepo airportRepo;


    public AirportService(AirportRepo airportRepo) {
        this.airportRepo = airportRepo;
    }


    public List<Airport>getAll(){
        return airportRepo.findAll();
    }
    public  Airport create(Airport airport){
        return airportRepo.save(airport);
    }


   public Airport update(int id, Airport airport){
        Airport airport1=airportRepo.findByAirportId(id);
        airport1.setAirportName(airport.getAirportName());
        airport1.setIata(airport.getIata());
        airport1.setIacao(airport.getIacao());
        return airportRepo.save(airport1);
    }





    public void delete(int id){
         airportRepo.deleteById(id);
    }
}
