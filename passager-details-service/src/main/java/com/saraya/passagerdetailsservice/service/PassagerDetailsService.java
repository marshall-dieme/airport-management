package com.saraya.passagerdetailsservice.service;

import com.saraya.passagerdetailsservice.model.PassagerDetails;
import com.saraya.passagerdetailsservice.model.PassagerDetailsDTO;
import com.saraya.passagerdetailsservice.repository.PassagerDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PassagerDetailsService {

    @Autowired
    private ModelMapper mapper;

    private final PassagerDetailsRepository repo;

    public PassagerDetailsService(PassagerDetailsRepository repo) {
        this.repo = repo;
    }

    public List<PassagerDetails> getAll(){
        return repo.findAll();
    }

    public  PassagerDetails getByEmail(
            String email){
        return repo.findByEmail(email);
    }

    public PassagerDetails create (PassagerDetailsDTO passagerDetails){
        PassagerDetails details = mapper.map(passagerDetails, PassagerDetails.class);
        //details.setBirthdate(LocalDate.parse(passagerDetails.getBirthdate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return repo.save(details);
    }

    public PassagerDetails update(PassagerDetails passagerDetails){
        return repo.save(mapper.map(passagerDetails , PassagerDetails.class));
    }

    public void deleteByTelephone(String email){
        PassagerDetails passagerDetails = repo.findByEmail(email);
        repo.delete(passagerDetails);
    }

    public void deleteById(int passagerDetailsId){
        repo.deleteById(passagerDetailsId);
    }

    public PassagerDetails findByEmail(String email) {
        return repo.findByEmail(email);
    }

}
