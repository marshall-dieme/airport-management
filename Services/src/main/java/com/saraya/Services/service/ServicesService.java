package com.saraya.Services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.saraya.Services.entity.Services;
import com.saraya.Services.repository.ServicesRepo;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class ServicesService {
    
    private final ServicesRepo repository;

    public List<Services> getAllServices() {
        return repository.findAll();
    }

    public Services getService(Long service_id) {
        return repository.findById(service_id).orElse(new Services());
    }

    public Services saveService(Services service) {
        return repository.save(service);
    }

    public void deleteService(Long service_id){
        repository.deleteById(service_id);
    }

}