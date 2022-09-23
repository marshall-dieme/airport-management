package com.saraya.Passengerservice.repository;

import com.saraya.Passengerservice.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    @Query("select p from Passenger p where p.passport_no = ?1")
    Passenger findByPassport_no(String passport_no);

    Passenger findPassengerByFirstnameAndLastname(String firstname, String lastname);
}
