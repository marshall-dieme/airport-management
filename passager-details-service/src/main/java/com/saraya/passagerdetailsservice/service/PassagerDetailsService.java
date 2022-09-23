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

    public  PassagerDetails getByTelephone(
            String telephone){
        return repo.findByTelephone(telephone);
    }

    public PassagerDetails create (PassagerDetails passagerDetails){
        return repo.save(passagerDetails);
    }

    public PassagerDetails update(PassagerDetails passagerDetails){
        return repo.save(passagerDetails);
    }

    public void deleteByTelephone(String telephone){
        PassagerDetails passagerDetails = repo.findByTelephone(telephone);
        repo.delete(passagerDetails);
    }

    public void deleteById(int passagerDetailsId){
        repo.deleteById(passagerDetailsId);
    }

    public PassagerDetails findByTelephone(String telephone) {
        return repo.findByTelephone(telephone);
    }

}
