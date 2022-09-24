package com.microservices.passengerdetailsairportservices.repository;


import com.microservices.passengerdetailsairportservices.entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails, Long> {

    PassengerDetails findByIdPassenger(String idPassenger);

}
