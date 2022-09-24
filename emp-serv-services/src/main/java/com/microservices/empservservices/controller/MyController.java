package com.microservices.empservservices.controller;


import com.microservices.empservservices.entity.EmpServRelation;
import com.microservices.empservservices.repository.MyRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
public class MyController {

    private final MyRepo repo;

    public MyController(MyRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/{idServ}/{idEmp}")
    public void create(@PathVariable String idServ,
                       @PathVariable String idEmp) {
        EmpServRelation relation = new EmpServRelation();
        relation.setServId(idServ);
        relation.setEmpId(Long.valueOf(idEmp));
        repo.save(relation);
    }
}
