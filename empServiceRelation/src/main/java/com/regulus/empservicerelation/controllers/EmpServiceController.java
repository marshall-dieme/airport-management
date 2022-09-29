package com.regulus.empservicerelation.controllers;

import com.regulus.empservicerelation.models.EmpServiceRelation;
import com.regulus.empservicerelation.repositories.EmpServiceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empServiceRelation")
public class EmpServiceController {

    private final EmpServiceRepository empServiceRepository;


    public EmpServiceController(EmpServiceRepository empServiceRepository) {
        this.empServiceRepository = empServiceRepository;
    }

    @GetMapping("/{empId}/{serviceId}")
    public void create(@PathVariable("empId") Integer empId, @PathVariable("serviceId") Integer serviceId){
        EmpServiceRelation relation = new EmpServiceRelation();
        relation.setEmpId(empId);
        relation.setServiceId(serviceId);
        empServiceRepository.save(relation);
    }

    @GetMapping
    public List<EmpServiceRelation> get(){
        return empServiceRepository.findAll();
    }
}
