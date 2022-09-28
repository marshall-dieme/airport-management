package com.example.ivo.modelcontr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ivo.dao2.Reposervice;
import com.example.ivo.entiti.Service;
import com.example.ivo.exception2.ResourceNotFoundException;


@RestController
@RequestMapping(value="/api/cc")
public class Controller {

	@Autowired
    private Reposervice chico;

    @GetMapping("/services")
    public List<Service> getAllService() {
        return chico.findAll();
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Service> getEmployeeById(@PathVariable(value = "id") Long serciceid)
        throws ResourceNotFoundException {
        Service service = chico.findById(serciceid)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + serciceid));
        return ResponseEntity.ok().body(service);
    }
    
    @PostMapping("/services")
    public Service createService(@Validated @RequestBody Service service) {
        return chico.save(service);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updatedService(@PathVariable(value = "id") Long serciceid,
    		@Validated @RequestBody Service serviceDetails) throws ResourceNotFoundException {
        Service service = chico.findById(serciceid)
        .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + serciceid));
         
        service.setService_name(serviceDetails.getService_name());
        
        
        final Service updatedService = chico.save(service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/services/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long serviceid)
         throws ResourceNotFoundException {
        Service service = chico.findById(serviceid)
       .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + serviceid));

        chico.delete(service);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


