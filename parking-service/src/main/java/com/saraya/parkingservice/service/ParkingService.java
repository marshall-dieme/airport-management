package com.saraya.parkingservice.service;

import com.saraya.parkingservice.model.Parking;
import com.saraya.parkingservice.repository.ParkingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    @Autowired
    private ModelMapper mapper;

    private final ParkingRepository repo;

    public ParkingService(ParkingRepository repo) {
        this.repo = repo;
    }

    public List<Parking> getAll(){
        return repo.findAll();
    }

    public  Parking getByNameAndEmail(
           String name , String email){
        return repo.findByNameAndEmail(name , email);
    }

    public Parking create (Parking parking){
        Parking park = mapper.map(parking, Parking.class);
        return repo.save(park);
    }

    public Parking update(Parking parking){
        return repo.save(mapper.map(parking , Parking.class));
    }

    public void deleteByNameAndEmail(String name , String email){
        Parking parking = repo.findByNameAndEmail(name,email);
        repo.delete(parking);
    }

    public void deleteById(int parkingId){
        repo.deleteById(parkingId);
    }
}
