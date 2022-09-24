package com.saraya.service_employee.controller;


import com.saraya.service_employee.model.ServiceEmployeeRelation;
import com.saraya.service_employee.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
public class controller {

  private final Repository repository;

    public controller(Repository repository) {
        this.repository = repository;

    }
    @GetMapping("/{service_id}/{employee_id")
    public void create (@PathVariable("id") long service_id, @PathVariable("id") long employee_id){
        ServiceEmployeeRelation relation = new ServiceEmployeeRelation();
        relation.setService_id(service_id);
        relation.setEmployee_id(employee_id);
        repository.save(relation);
    }
}
