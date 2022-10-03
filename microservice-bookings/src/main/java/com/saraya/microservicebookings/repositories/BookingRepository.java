package com.saraya.microservicebookings.repositories;

import com.saraya.microservicebookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
