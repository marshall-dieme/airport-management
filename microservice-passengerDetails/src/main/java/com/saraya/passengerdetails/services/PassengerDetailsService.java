package com.saraya.passengerdetails.services;


import com.saraya.passengerdetails.exceptions.ResourceNotFoundException;
import com.saraya.passengerdetails.models.PassengerDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PassengerDetailsService {

    PassengerDetails add(PassengerDetails passengerDetails);
    PassengerDetails update(PassengerDetails passengerDetails);
    PassengerDetails getPassengerDetails(Long passengerDetails_id) throws ResourceNotFoundException;
    Page<PassengerDetails> getPassengerDetailss(Pageable pageable);
    void delete(Long passengerDetails_id) throws ResourceNotFoundException;
    boolean existPassengerDetails(Long passengerDetails_id);

}
