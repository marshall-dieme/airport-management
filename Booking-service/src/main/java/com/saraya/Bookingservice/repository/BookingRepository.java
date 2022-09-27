package com.saraya.Bookingservice.repository;

import com.saraya.Bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b where b.booking_id = ?1")
    Booking findBookingByBooking_id(Long booking_id);
}
