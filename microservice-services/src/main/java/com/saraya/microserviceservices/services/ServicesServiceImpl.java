package com.saraya.microserviceservices.services;

import com.saraya.microserviceservices.exceptions.ResourceNotFoundException;
import com.saraya.microserviceservices.models.Services;
import com.saraya.microserviceservices.repositories.ServicesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository servicesRepository;

    public ServicesServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }


    @Override
    public Services add(Services services) {

        return this.servicesRepository.save(services);
    }

    @Override
    public Services update(Services services) {
        return this.servicesRepository.save(services);
    }

    @Override
    public Services getServices(Long services_id) throws ResourceNotFoundException {
        Optional<Services> services = this.servicesRepository.findById(services_id);
        if (!services.isPresent())
            throw new ResourceNotFoundException("Services not available");
        return services.get();
    }

    @Override
    public Page<Services> getServicess(Pageable pageable) {
        return this.servicesRepository.findAll(pageable);
    }

    @Override
    public void delete(Long services_id) throws ResourceNotFoundException {
        if (!this.existServices(services_id))
            throw new ResourceNotFoundException("impossible to remove this Services");

        this.servicesRepository.deleteById(services_id);
    }

    @Override
    public boolean existServices(Long services_id) {
        return this.servicesRepository.existsById(services_id);
    }
}
