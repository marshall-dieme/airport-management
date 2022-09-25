package com.saraya.microservice.passengerDetailservice.service;

import com.saraya.microservice.passengerDetailservice.bean.PassagerDetail;
import com.saraya.microservice.passengerDetailservice.bean.PassagerDetailDto;
import com.saraya.microservice.passengerDetailservice.repo.PassagerDetailRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassagerDetailService {
    private final PassagerDetailRepo repo;


    public PassagerDetailService(PassagerDetailRepo repo) {
        this.repo = repo;
    }

    public List<PassagerDetail> getAll() {
        return repo.findAll();
    }

    public PassagerDetail getById(int id) {
        return repo.findById(id).get();
    }

    public PassagerDetail create(PassagerDetailDto dto) {
        PassagerDetail pd = new PassagerDetail();
        changeToModel(dto, pd);
        return repo.save(pd);
    }

    private static void changeToModel(PassagerDetailDto dto, PassagerDetail pd) {
    }

    public PassagerDetail update(PassagerDetailDto dto) {
        PassagerDetail pd = new PassagerDetail();
        pd.setPassager_details_id(dto.getPassager_details_id());
        changeToModel(dto, pd);
        return repo.save(pd);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

   

}
