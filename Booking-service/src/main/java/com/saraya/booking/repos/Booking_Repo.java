package com.saraya.booking.repos;

import com.saraya.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking_Repo extends JpaRepository<Booking,Long> {
    @Query("select b from Booking b WHERE b.booking_id=:booking_id" )
    Booking retrieveById(Long booking_id);

}
