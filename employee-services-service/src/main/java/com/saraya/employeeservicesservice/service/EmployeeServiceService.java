package com.saraya.employeeservicesservice.service;

import com.saraya.employeeservicesservice.bean.EmployeeService;
import com.saraya.employeeservicesservice.repository.EmployeeServiceRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Integer> getServiceId() {
        List<EmployeeService> list = repo.findAll();
        ArrayList<Integer> idServices = new ArrayList<>();
        for (EmployeeService employeeService : list) {
            idServices.add(employeeService.getServiceId());
        }
        return idServices;
    }

    public List<Integer> getEmployeeId() {
        List<EmployeeService> list = repo.findAll();
        ArrayList<Integer> idEmployee = new ArrayList<>();
        for (EmployeeService employeeService : list) {
            idEmployee.add(employeeService.getEmployeeId());
        }
        return idEmployee;
    }
}
