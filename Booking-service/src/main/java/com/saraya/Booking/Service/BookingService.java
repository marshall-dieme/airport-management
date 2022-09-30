package com.saraya.Booking.Service;

import java.util.List;

import javax.transaction.Transactional;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saraya.Booking.model.Booking;
import com.saraya.Booking.repository.BookingRepo;

@Service
@Transactional
public class BookingService {
	@Autowired
	//private ModelMapper mapper;
	private final BookingRepo repo;
	 
	public BookingService(BookingRepo repo) {
		this.repo = repo;
	}
	
	public List<Booking> getAll(){
        return repo.findAll();
	}
	
	 public  Booking getBySeat(String seat){
	        return repo.findBySeat(seat);
	    }

	 public Booking create (Booking booking){
	        return repo.save(booking);
	    }
	 
	 public Booking update(Booking booking){
	        return repo.save(booking);
	    }
	 
	 
	 public void deleteById(int bookingId ){
		 Booking booking = repo.findByBookingId(bookingId);
	        repo.delete(booking);
	    }
	 
	    public void deleteBySeat(String seat){
	        repo.deleteBySeat(seat);
	    }


	    public Booking findBySeat(String seat ) {
	        return repo.findBySeat(seat);
	    }

		public Booking findByBookingId(int bookingId) {
			return repo.findByBookingId(bookingId);
		}

		

		
		

		

}
