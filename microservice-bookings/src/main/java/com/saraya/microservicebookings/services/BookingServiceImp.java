package com.saraya.microservicebookings.services;

import com.saraya.microservicebookings.exceptions.ResourceNotFoundException;
import com.saraya.microservicebookings.models.Booking;
import com.saraya.microservicebookings.repositories.BookingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking add(Booking booking) throws ResourceNotFoundException {
        return getBooking(booking);
    }

    @Override
    public Booking update(Booking booking) throws ResourceNotFoundException {
        return getBooking(booking);
    }

    private Booking getBooking(Booking booking) throws ResourceNotFoundException {

        if(booking.getFlightId()!=null){
            try {
                Map<String,Long> paramFlights = new HashMap<>();
                paramFlights.put("flight_id",booking.getFlightId());
                Long flightId = new RestTemplate().getForEntity("http://localhost:9009/flights/flight_id/{flight_id}",
                        Long.class,paramFlights).getBody();

                booking.setFlightId( flightId);
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Flight ID = %d not found",booking.getFlightId()));
            }

        }

        if(booking.getPassengerId()!=null){
            try {
                Map<String,Long> paramPassengers = new HashMap<>();
                paramPassengers.put("passenger_id ",booking.getPassengerId());
                Long passengerId = new RestTemplate().getForEntity("http://localhost:9010/passengers/passenger_id/{passenger_id}",
                        Long.class,paramPassengers).getBody();

                booking.setPassengerId( passengerId );
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Passenger ID = %d not found",booking.getPassengerId()));
            }
        }

        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking getBooking(Long booking_id) throws ResourceNotFoundException {
        Optional<Booking> booking = this.bookingRepository.findById(booking_id);
        if (!booking.isPresent())
            throw new ResourceNotFoundException("Booking not available");
        return booking.get();
    }

    @Override
    public Page<Booking> getBookings(Pageable pageable) {
        return this.bookingRepository.findAll(pageable);
    }

    @Override
    public void delete(Long booking_id) throws ResourceNotFoundException {
      if (!this.existBooking(booking_id))
          throw new ResourceNotFoundException("impossible to remove this Booking");

      this.bookingRepository.deleteById(booking_id);
    }

    @Override
    public boolean existBooking(Long booking_id) {
        return this.bookingRepository.existsById(booking_id);
    }
}
