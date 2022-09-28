package com.saraya.bookingservice.service;

import com.saraya.bookingservice.model.BookingModel;
import com.saraya.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

   private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public List<BookingModel> getAll(){
        return repo.findAll();
    }

    public  BookingModel getBySeat(
            String seat){
        return repo.findBySeat(seat);
    }

    public BookingModel create (BookingModel bookingModel){
        return repo.save(bookingModel);
    }

    public BookingModel update(BookingModel bookingModel){
        return repo.save(bookingModel);
    }

    public void deleteBySeat(String seat){
        BookingModel bookingModel = repo.findBySeat(seat);
        repo.delete(bookingModel);
    }

    public void deleteById(int bookingId){
        repo.deleteById(bookingId);
    }


}
