package com.example.rentalsservice.service;

import com.example.rentalsservice.model.Rental;
import com.example.rentalsservice.model.RentalDto;
import com.example.rentalsservice.repos.RentalRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepo repo;

    public RentalService(RentalRepo repo) {
        this.repo = repo;
    }


    public List<Rental> getAll() {
        return repo.findAll();

    }

    public Optional<Rental> getById(Long id) {
        return repo.findById(id);
    }




    public Rental create(RentalDto dto) {
        Rental rental= new Rental();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("passportNo", dto.getPassportNo());

        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, urlValues).getBody();
        changeToModel(dto, rental);
        rental.setPassengerId(passengerId);
        return (Rental) repo.save(rental);
    }


    private static void changeToModel(RentalDto dto, Rental rental) {

        rental.setName(dto.getName());
        rental.setEmail(dto.getEmail());
        rental.setContact(dto.getContact());
        rental.setLicenceNo(dto.getLicenceNo());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate pickupDate = LocalDate.parse(dto.getPickupDate(), format);
        rental.setPickupDate(pickupDate);

        LocalDate returnDate = LocalDate.parse(dto.getReturnDate(), format);
        rental.setReturnDate(returnDate);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime pickupTime= LocalDateTime.parse(dto.getPickupTime(),format2);
        rental.setPickupTime(pickupTime);



        LocalDateTime returnTime= LocalDateTime.parse(dto.getPickupTime(),format2);
        rental.setReturnTime(returnTime);


        rental.setCarNo(dto.getCarNo());
        rental.setAmount(dto.getAmount());




    }

    public List <Rental> getRentalByPassenger(String passportNo) {
        Map<String, String> values = new HashMap<>();
        values.put("passportNo", passportNo);

        RestTemplate template = new RestTemplate();
        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, values).getBody();

        return repo.findByPassengerId(passengerId);
    }

    public Rental update(RentalDto dto) {
        Rental rental = new Rental();
        rental.setRentalId(dto.getRentalId());
        changeToModel(dto, rental);
        return (Rental) repo.save(rental);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
