package com.microservices.passengerdetailsairportservices.service;


import com.microservices.passengerdetailsairportservices.entity.PassengerDetails;
import com.microservices.passengerdetailsairportservices.entity.PassengerDetailsDTO;
import com.microservices.passengerdetailsairportservices.repository.PassengerDetailsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PassengerDetailsService {

    private final PassengerDetailsRepo repo;

    public PassengerDetailsService(PassengerDetailsRepo repo) {
        this.repo = repo;
    }

    public List<PassengerDetails> getAll(){
        return repo.findAll();
    }

    public Optional<PassengerDetails> getById(Long passengerdetailsId) {
        return repo.findById(passengerdetailsId);
    }

    public PassengerDetails create(PassengerDetailsDTO dto) {
        PassengerDetails passengerDetails = new PassengerDetails();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("NumberPassport", dto.getNumberPassport());
        String idpassenger = template.getForEntity(
                        "http://localhost:8005/passenger/NumberPassport/{NumberPassport}",
                        String.class,
                        urlValues)
                .getBody();
        changeToModel(dto, passengerDetails);
        passengerDetails.setIdPassenger(idpassenger);
        return repo.save(passengerDetails);
    }

    public PassengerDetails update(PassengerDetailsDTO dto) {
        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setPassengerdetailsId(dto.getPassengerdetailsId());
        changeToModel(dto, passengerDetails);
        return repo.save(passengerDetails);
    }

    private static void changeToModel(PassengerDetailsDTO dto, PassengerDetails passengerDetails) {
        passengerDetails.setSexe(dto.getSexe());
        passengerDetails.setStreet(dto.getStreet());
        passengerDetails.setCity(dto.getCity());
        passengerDetails.setZip(dto.getZip());
        passengerDetails.setCountry(dto.getCountry());
        passengerDetails.setEmail(dto.getEmail());
        passengerDetails.setTelephone(dto.getTelephone());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(dto.getBirthdate(), format);
        passengerDetails.setBirthdate(birthDate);

    }

    public void deleteById(Long passengerdetailsId) {
        repo.deleteById(passengerdetailsId);
    }

    public PassengerDetails findPassengerByDetails(String NumberPassport){
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("NumberPassport", NumberPassport);
        String idpassenger = template.getForEntity(
                        "http://localhost:8005/passenger/NumberPassport/{NumberPassport}",
                        String.class,
                        urlValues)
                .getBody();

        return repo.findByIdPassenger(idpassenger);
    }
}
