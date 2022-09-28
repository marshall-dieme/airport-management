package com.saraya.rentalsservice.service;

import com.saraya.rentalsservice.model.Rentals;
import com.saraya.rentalsservice.repository.RentalsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentalsService {

    private final RentalsRepository repo;


    public RentalsService(RentalsRepository repo) {
        this.repo = repo;
    }

    public List<Rentals> getAll(){
        return repo.findAll();
    }

    public  Rentals getByLicenceNo(
            String licenceNo){
        return repo.findByLicenceNo(licenceNo);
    }

    public Rentals create (Rentals rentals){
        return repo.save(rentals);
    }

    public Rentals update(Rentals rentals){
        return repo.save(rentals);
    }

    public void deleteByLicenceNo(String licenceNo){
        Rentals rentals = repo.findByLicenceNo(licenceNo);
        repo.delete(rentals);
    }
    public void deleteById(int rentalId){
        repo.deleteById(rentalId);
    }

}
