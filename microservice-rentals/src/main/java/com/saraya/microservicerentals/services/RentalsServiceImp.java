package com.saraya.microservicerentals.services;


import com.saraya.microservicerentals.exceptions.ResourceNotFoundException;
import com.saraya.microservicerentals.models.Rentals;
import com.saraya.microservicerentals.repositories.RentalsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RentalsServiceImp implements RentalsService {
    private final RentalsRepository rentalsRepository;

    public RentalsServiceImp(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    @Override
    public Rentals add(Rentals rentals) throws ResourceNotFoundException {
        return getRentals(rentals);
    }

    @Override
    public Rentals update(Rentals rentals) throws ResourceNotFoundException {
        return getRentals(rentals);
    }
    private Rentals getRentals(Rentals rentals) throws ResourceNotFoundException {

        if(rentals.getPassengerId()!=null){
            try {
                Map<String,Long> paramPassengers = new HashMap<>();
                paramPassengers.put("passenger_id ",rentals.getPassengerId());
                Long passengerId = new RestTemplate().getForEntity("http://localhost:9010/passengers/passenger_id/{passenger_id}",
                        Long.class,paramPassengers).getBody();

                rentals.setPassengerId( passengerId );
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Passenger ID = %d not found",rentals.getPassengerId()));
            }
        }

        return this.rentalsRepository.save(rentals);
    }
    @Override
    public Rentals getRentals(Long rentals_id) throws ResourceNotFoundException {
        Optional<Rentals> rentals = this.rentalsRepository.findById(rentals_id);
        if (!rentals.isPresent())
            throw new ResourceNotFoundException("Rentals not available");
        return rentals.get();
    }

    @Override
    public Page<Rentals> getRentalss(Pageable pageable) {
        return this.rentalsRepository.findAll(pageable);
    }

    @Override
    public void delete(Long rentals_id) throws ResourceNotFoundException {
      if (!this.existRentals(rentals_id))
          throw new ResourceNotFoundException("impossible to remove this Rentals");

      this.rentalsRepository.deleteById(rentals_id);
    }

    @Override
    public boolean existRentals(Long rentals_id) {
        return this.rentalsRepository.existsById(rentals_id);
    }
}
