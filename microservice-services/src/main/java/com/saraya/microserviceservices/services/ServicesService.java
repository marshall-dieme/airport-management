package com.saraya.microserviceservices.services;

import com.saraya.servicesservice.models.Services;
import com.saraya.servicesservice.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicesService {
    Services add(Services services);
    Services update(Services services);
    Services getServices(Long services_id) throws ResourceNotFoundException;
    Page<Services> getServicess(Pageable pageable);
    void delete(Long services_id) throws ResourceNotFoundException;
    boolean existServices(Long services_id);
}
