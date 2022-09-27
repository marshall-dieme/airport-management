package com.saraya.Servicesservice.service;

import com.saraya.Servicesservice.model.Services;
import com.saraya.Servicesservice.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicesService {

    private final ServicesRepository repository;

    public List<Services> getAllServices() {
        return repository.findAll();
    }

    public Services getServices(Long services_id) {
        return repository.findById(services_id).orElse(null);
    }

    public Services getServicesByName(String service_name) {
        return repository.getServiceByService_name(service_name);
    }

    public Services saveService(Services service) {
        return repository.save(service);
    }

    public Services updateService(Services service) {
        return repository.save(service);
    }

    public void deleteService(Long services_id) {
        repository.deleteById(services_id);
    }
}
