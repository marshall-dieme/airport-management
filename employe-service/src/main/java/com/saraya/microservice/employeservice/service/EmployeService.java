package com.saraya.microservice.employeservice.service;


import com.saraya.microservice.employeservice.bean.Employee;
import com.saraya.microservice.employeservice.bean.EmployeeDTo;
import com.saraya.microservice.employeservice.repo.EmpRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeService {

    private final EmpRepo repo;





    public EmployeService(EmpRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee getById(int id) {
        return repo.findById(id).get();
    }

    public Employee create(EmployeeDTo dTo) {
        Employee e = new Employee();
        changeToModel(dTo, e);

        return repo.save(e);
    }

    private static void changeToModel(EmployeeDTo dTo, Employee e) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("YY/MM/DD");
        e.setFirstname(dTo.getFirstname());
        e.setLastname(dTo.getLastname());
        e.setBirthdate(LocalDate.now());
        e.setSex(dTo.getSex());
        e.setStreet(dTo.getStreet());
        e.setCity(dTo.getCity());
        e.setZip(dTo.getZip());
        e.setCountry(dTo.getCountry());
        e.setEmail(dTo.getEmail());
        e.setTelephone(dTo.getTelephone());
        e.setSalary(dTo.getSalary());
        e.setUsername(dTo.getUsername());
        e.setPassword(dTo.getPassword());
    }

    public Employee update(EmployeeDTo dTo) {
        Employee e = new Employee();
        e.setEmploye_id(dTo.getEmploye_id());
        changeToModel(dTo, e);
        return repo.save(e);



    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/


}
