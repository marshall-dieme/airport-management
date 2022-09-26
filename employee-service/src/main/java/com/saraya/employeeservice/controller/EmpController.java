package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.model.EmployeeDto;
import com.saraya.employeeservice.services.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    private final EmpService service;

    private final Logger LOGGER = LoggerFactory.getLogger(EmpController.class);

    public EmpController(EmpService service) {
        this.service = service;
    }


    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{serviceName}/employee")
    public List<Employee> getEmpByDept(@PathVariable String serviceName) {
        return service.getByServices(serviceName);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDto dto) {
        LOGGER.debug(dto.toString());
        return service.create(dto);
    }



    @PostMapping("/create")
    public Employee createWithRelation(@RequestBody EmployeeDto dto) {

        return service.createWithRelation(dto);
    }

    @PutMapping("/")
    public Employee update (@RequestBody EmployeeDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
