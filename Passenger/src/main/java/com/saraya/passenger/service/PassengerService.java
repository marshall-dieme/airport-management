package com.saraya.passenger.service;

import com.saraya.passenger.model.Passenger;
import com.saraya.passenger.model.PassengerDto;
import com.saraya.passenger.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PassengerService {

    private final PassengerRepo repo;

    public PassengerService(PassengerRepo repo) {
        this.repo = repo;
    }

    public List<Passenger> getAll(){
        return repo.findAll();
    }

    public Long getById(int passport_no){
        return repo.getByIdPassenger(passport_no);
    }

    public Passenger create(PassengerDto dto){
        Passenger passenger = new Passenger();

        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("email", dto.getEmail());
        RestTemplate template = new RestTemplate();
        Long passengerDetailsId = template.getForEntity("http://localhost:8700/passengerDetails/email/{email}",
                Long.class, urlValues).getBody();

        changeToModel(dto, passenger);
        passenger.setPassengerDetailsId(passengerDetailsId);
        return  repo.save(passenger);
    }
    public Passenger update(PassengerDto dto){
        Passenger passenger = new Passenger();
        passenger.setPassenger_id(dto.getPassenger_id());
        changeToModel(dto,passenger);

        return repo.save(passenger);
    }

    public Passenger  getPassengerByPassengerDetails(String email){
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("email", email);

        Long passengerDetailsId = template.getForEntity("http://localhost:8700/passengerDetails/email/{email}",
                Long.class, value).getBody();
        return  repo.findByPassengerDetailsId(passengerDetailsId);
    }
    private static void changeToModel(PassengerDto dto, Passenger passenger) {
        passenger.setFirstname(dto.getFirstname());
        passenger.setLastname(dto.getLastname());
        passenger.setPassport_no(dto.getPassport_no());


    }

    public void deleteById(Long passenger_id){
        repo.deleteById(passenger_id);
    }
}
