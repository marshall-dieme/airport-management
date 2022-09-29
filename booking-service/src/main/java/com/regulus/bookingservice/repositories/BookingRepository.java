package com.regulus.bookingservice.repositories;

import com.regulus.bookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("select b.booking_id from Booking b where b.seat=:seat")
    Integer findBySeat(int seat);
}
