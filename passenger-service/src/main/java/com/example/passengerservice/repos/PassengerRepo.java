package com.example.passengerservice.repos;

import com.example.passengerservice.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassengerRepo extends JpaRepository<Passenger,Long> {

    @Query("select p.passengerId from Passenger p where p.passportNo=:passportNo")
    Long getPassengerId(String passportNo);


}
