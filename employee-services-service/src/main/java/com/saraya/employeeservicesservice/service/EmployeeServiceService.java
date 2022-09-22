package com.saraya.employeeservicesservice.service;

import com.saraya.employeeservicesservice.bean.EmployeeService;
import com.saraya.employeeservicesservice.repository.EmployeeServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceService {

    private final EmployeeServiceRepo repo;

    public EmployeeServiceService(EmployeeServiceRepo repo) {
        this.repo = repo;
    }

    public EmployeeService create(EmployeeService employeeService){
        return repo.save(employeeService);
    }

    public List<EmployeeService> getAll() {
        return repo.findAll();
    }
}
