package com.saraya.passengerdetails.services;

import com.saraya.passengerdetails.exceptions.ResourceNotFoundException;
import com.saraya.passengerdetails.models.PassengerDetails;
import com.saraya.passengerdetails.repositories.PassengerDetailsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PassengerDetailsServiceImp implements PassengerDetailsService {
    private final PassengerDetailsRepository passengerDetailsRepository;

    public PassengerDetailsServiceImp(PassengerDetailsRepository passengerDetailsRepository) {
        this.passengerDetailsRepository = passengerDetailsRepository;
    }

    @Override
    public PassengerDetails add(PassengerDetails passengerDetails) throws ResourceNotFoundException {
        return getPassengerDetails(passengerDetails);
    }

    @Override
    public PassengerDetails update(PassengerDetails passengerDetails) throws ResourceNotFoundException {
        return getPassengerDetails(passengerDetails);
    }

    private PassengerDetails getPassengerDetails(PassengerDetails passengerDetails) throws ResourceNotFoundException {

        if(passengerDetails.getPassengerId()!=null){
            try {
                Map<String,Long> paramPassengers = new HashMap<>();
                paramPassengers.put("passenger_id ",passengerDetails.getPassengerId());
                Long passengerId = new RestTemplate().getForEntity("http://localhost:9010/passengers/passenger_id/{passenger_id}",
                        Long.class,paramPassengers).getBody();

                passengerDetails.setPassengerId( passengerId );
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Passenger ID = %d not found",passengerDetails.getPassengerId()));
            }
        }

        return this.passengerDetailsRepository.save(passengerDetails);
    }

    @Override
    public PassengerDetails getPassengerDetails(Long passengerDetails_id) throws ResourceNotFoundException {
        Optional<PassengerDetails> passengerDetails = this.passengerDetailsRepository.findById(passengerDetails_id);
        if (!passengerDetails.isPresent())
            throw new ResourceNotFoundException("PassengerDetails not available");
        return passengerDetails.get();
    }

    @Override
    public Page<PassengerDetails> getPassengerDetailss(Pageable pageable) {
        return this.passengerDetailsRepository.findAll(pageable);
    }

    @Override
    public void delete(Long passengerDetails_id) throws ResourceNotFoundException {
      if (!this.existPassengerDetails(passengerDetails_id))
          throw new ResourceNotFoundException("impossible to remove this PassengerDetails");

      this.passengerDetailsRepository.deleteById(passengerDetails_id);
    }

    @Override
    public boolean existPassengerDetails(Long passengerDetails_id) {
        return this.passengerDetailsRepository.existsById(passengerDetails_id);
    }
}
