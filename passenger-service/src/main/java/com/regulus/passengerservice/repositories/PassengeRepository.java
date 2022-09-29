package com.regulus.passengerservice.repositories;

import com.regulus.passengerservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengeRepository extends JpaRepository<Passenger, Integer> {

    @Query("select p.passenger_id from Passenger p where p.passport_no=:passport")
    Integer findByPassport_no(String passport);
}
