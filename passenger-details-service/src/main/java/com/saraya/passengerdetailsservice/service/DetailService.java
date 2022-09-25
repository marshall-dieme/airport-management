package com.saraya.passengerdetailsservice.service;

import com.saraya.passengerdetailsservice.model.Detail;
import com.saraya.passengerdetailsservice.model.DetailDto;
import com.saraya.passengerdetailsservice.repos.DetailRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DetailService {

    private final DetailRepo repo;

    public DetailService(DetailRepo repo) {
        this.repo = repo;
    }

    public List<Detail> getAll() {
        return repo.findAll();

    }

    public Optional<Detail> getById(Long id) {
        return repo.findById(id);
    }




    public Detail create(DetailDto dto) {
        Detail detail= new Detail();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("passportNo", dto.getPassportNo());

        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, urlValues).getBody();
        changeToModel(dto, detail);
        detail.setPassengerId(passengerId);
        return (Detail) repo.save(detail);
    }


    private static void changeToModel(DetailDto dto, Detail detail) {

        detail.setEmail(dto.getEmail());
        detail.setCountry(dto.getCountry());
        detail.setSex(dto.getSex());
        detail.setStreet(dto.getStreet());
        detail.setTelephone(dto.getTelephone());

        detail.setZip(dto.getZip());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthdate = LocalDate.parse(dto.getBirthdate(), format);
        detail.setBirthdate(birthdate);
        detail.setCity(dto.getCity());




    }

    public Detail getDetailByPassenger(String passportNo) {
        Map<String, String> values = new HashMap<>();
        values.put("passportNo", passportNo);

        RestTemplate template = new RestTemplate();
        Long passengerId = template.getForEntity("http://localhost:8800/passengers/{passportNo}",
                Long.class, values).getBody();

        return repo.findByPassengerId(passengerId);
    }

    public Detail update(DetailDto dto) {
        Detail detail = new Detail();
        detail.setPassengerDetailId(dto.getPassengerDetailId());
        changeToModel(dto, detail);
        return (Detail) repo.save(detail);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }

}
