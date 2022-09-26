package com.saraya.employeeservice;

import com.saraya.employeeservice.models.Employee;
import com.saraya.employeeservice.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    public CommandLineRunner loadData(EmployeeRepository employeeRepository){
        return (args)->{
            //save Employees
            employeeRepository.save(new Employee( null,"Ibrahim","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Abou","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Omar","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Hassan","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Fall","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Dieynaba","Ahamada", LocalDate.now(),"F","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Karim","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Dida","Ahamada", LocalDate.now(),"F","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Sali","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Tomie","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));
            employeeRepository.save(new Employee( null,"Alemeda","Ahamada", LocalDate.now(),"M","12 Avenu","Dakar","Somp","Sénégal","ibra@gmail.com","778236334", 400000.0F,"ibra","ibra@passe"));








        };
    }
}
