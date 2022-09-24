package com.saraya.service.service;

import com.saraya.service.model.Services;
import com.saraya.service.repository.ServicesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicesService {
    private final ServicesRepo repository;

    public List<Services> getAllServices() {
        return repository.findAll();
    }

    public Services getServices(Long services_id) {
        return repository.findById(services_id).orElse(new Services());
    }

    public Services getServicesByName(String service_name) {
        return repository.getServiceByService_name(service_name);
    }

    public Services saveServices(Services service) {
        return repository.save(service);
    }

    public Services updateServices(Services service) {
        return repository.save(service);
    }
    public void deleteServices(String services_name) {
        repository.deleteById(Long.valueOf(services_name));
    }

}
