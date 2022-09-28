package com.saraya.passenger.repo;

import com.saraya.passenger.model.Passenger;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long> {

    @Query("select  p.passenger_id FROM Passenger p WHERE p.passport_no=:passport_no")
 Long getByIdPassenger(int passport_no);

    Passenger findByPassengerDetailsId(Long passengerDetailsId);
}
