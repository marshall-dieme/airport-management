package com.example.bookingservice.repos;

import com.example.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    @Query("select b.bookingId from Booking b where b.seat=:seat and b.price=:price")
    Long getBookingId(String seat,Double price);

}
