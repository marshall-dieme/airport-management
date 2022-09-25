package com.spring.serviceemplrelation.controller;

import com.spring.serviceemplrelation.bean.ServiceEmplRelation;
import com.spring.serviceemplrelation.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
public class RelationController {

    @Autowired
    private RelationRepository repository;

    @GetMapping("/{idService}/{idEmployee}")
    public void create(@PathVariable int idService,@PathVariable int idEmployee ){
        ServiceEmplRelation serviceEmplRelation = new ServiceEmplRelation();
        serviceEmplRelation.setIdService(idService);
        serviceEmplRelation.setEmployeeId(idEmployee);
        repository.save(serviceEmplRelation);
    }
}
