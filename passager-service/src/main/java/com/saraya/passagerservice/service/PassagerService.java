package com.saraya.passagerservice.service;

import com.saraya.passagerservice.model.Passager;
import com.saraya.passagerservice.model.PassagerDTO;
import com.saraya.passagerservice.proxies.PassagerDetailProxy;
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

    @Autowired
    PassagerDetailProxy proxy;

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

    public PassagerDTO create (PassagerDTO dto){
        Passager passager = mapper.map(dto, Passager.class);
        passager = repo.save(passager);
        dto = proxy.create(dto);
        dto.setFirstName(passager.getFirstName());
        dto.setLastName(passager.getLastName());
        return dto;
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
