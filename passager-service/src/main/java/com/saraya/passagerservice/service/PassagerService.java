package com.saraya.passagerservice.service;

import com.saraya.passagerservice.model.Passager;
import com.saraya.passagerservice.model.PassagerDTO;
import com.saraya.passagerservice.repository.PassagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PassagerService {

    @Autowired
    private ModelMapper mapper;

    private final PassagerRepository repo;

    public PassagerService(PassagerRepository repo) {
        this.repo = repo;
    }

    public List<Passager> getAll(){
        return repo.findAll();
    }

    public  Passager getByFirstNameAndLastName(
            String firstName , String lastName){
        return repo.findByFirstNameAndLastName(firstName, lastName);
    }

    public Passager create (PassagerDTO dto){
        Passager passager = mapper.map(dto , Passager.class);
        RestTemplate template = new RestTemplate();
        Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("telephone") , dto.getTelephone());
        UrlValues.put(("birthdate") , dto.getBirthdate());
        UrlValues.put(("sex") , dto.getSex());
        UrlValues.put(("street") , dto.getStreet());
        UrlValues.put(("city") , dto.getCity());
        UrlValues.put(("country") , dto.getCountry());
        UrlValues.put(("email") , dto.getEmail());
        Integer passagerDetailsId = template.getForEntity(
        "http://localhost:8088/passagers-details/{telephone}",
                Integer.class, UrlValues)
        .getBody();
        passager.setPassagerDetailsId(passagerDetailsId);
        return repo.save(passager);
    }

    public Passager update(Passager passager){
        return repo.save(passager);
    }

    public void deleteByFirstNameAndLastName(String firstName , String lastName){
        Passager passager = repo.findByFirstNameAndLastName(firstName , lastName);
        repo.delete(passager);
    }
    public void deleteById(int passagerId){
        repo.deleteById(passagerId);
    }


}
