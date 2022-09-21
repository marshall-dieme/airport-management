package com.microservices.employeeserviceairport.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;

    private String firstname;

    private String lastname;

    @Column(columnDefinition = "date")
    private LocalDate birthDate;

    private String sexe;

    private String street;

    private String city;

    private String zip;

    private String country;

    private String email;

    private String telephone;

    private Double salary;

    @Column(unique = true)
    private String username;

    private String password;

    private String idServices;

    public Employee() {
    }

    public Employee(Long id_employee, String firstname, String lastname, LocalDate birthDate, String sexe, String street, String city, String zip, String country, String email, String telephone, Double salary, String username, String password, String idServices) {
        this.id_employee = id_employee;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.sexe = sexe;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.idServices = idServices;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdServices() {
        return idServices;
    }

    public void setIdServices(String idServices) {
        this.idServices = idServices;
    }
}
