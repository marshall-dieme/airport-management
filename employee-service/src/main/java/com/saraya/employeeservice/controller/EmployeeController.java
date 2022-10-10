package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.bean.Employee;
import com.saraya.employeeservice.dto.EmployeeDto;
import com.saraya.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("{employeeId}/{serviceName}")
    public String putServiceForEmployee(@PathVariable("employeeId") int employeeId,
                                        @PathVariable("serviceName") String serviceName){
        return service.putServiceForEmployee(employeeId, serviceName);
    }

    @GetMapping("/listServiceId")
    public List<Integer> getListServiceId(){
        return service.getListServiceId();
    }

    @GetMapping("/{username}")
    public int getIdByUsername(@PathVariable("username") String username){
        return service.getIdEmpByUsername(username);
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDto dto){
        return service.create(dto);
    }

    @PutMapping
    public Employee update(@RequestBody EmployeeDto dto){
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody EmployeeDto dto){
        service.delete(dto);
    }
}
