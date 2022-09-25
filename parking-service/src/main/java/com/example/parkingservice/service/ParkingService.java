package com.example.parkingservice.service;

import com.example.parkingservice.model.Parking;
import com.example.parkingservice.model.ParkingDto;
import com.example.parkingservice.repos.ParkingRepo;
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
public class ParkingService {
    private final ParkingRepo repo;

    public ParkingService(ParkingRepo repo) {
        this.repo = repo;
    }


    public List<Parking> getAll() {
        return repo.findAll();

    }

    public Optional<Parking> getById(Long id) {
        return repo.findById(id);
    }




    public Parking create(ParkingDto dto) {
        Parking parking= new Parking();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("passportNo", dto.getPassportNo());

        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, urlValues).getBody();
        changeToModel(dto, parking);
        parking.setPassengerId(passengerId);
        return (Parking) repo.save(parking);
    }


    private static void changeToModel(ParkingDto dto, Parking parking) {

        parking.setName(dto.getName());
        parking.setEmail(dto.getEmail());
        parking.setContact(dto.getContact());


        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate entryDate = LocalDate.parse(dto.getEntryDate(), format);
        parking.setEntryDate(entryDate);

        LocalDate exitDate = LocalDate.parse(dto.getExitDate(), format);
        parking.setExitDate(exitDate);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime entryTime= LocalDateTime.parse(dto.getEntryTime(),format2);
        parking.setEntryTime(entryTime);


        LocalDateTime exitTime= LocalDateTime.parse(dto.getExitTime(),format2);
        parking.setExitTime(exitTime);


        parking.setCarNo(dto.getCarNo());
        parking.setAmount(dto.getAmount());




    }

    public List <Parking> getParkingByPassenger(String passportNo) {
        Map<String, String> values = new HashMap<>();
        values.put("passportNo", passportNo);

        RestTemplate template = new RestTemplate();
        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, values).getBody();

        return repo.findByPassengerId(passengerId);
    }

    public Parking update(ParkingDto dto) {
        Parking parking = new Parking();
        parking.setParkingId(dto.getParkingId());
        changeToModel(dto, parking);
        return (Parking) repo.save(parking);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}
