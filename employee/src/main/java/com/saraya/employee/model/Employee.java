package com.saraya.employee.model;



import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;



    @Column(unique = true)
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String sex;
    private  String street;
    private String city;
    private String zip;
    private String country;
    private  String email;
    private int telephone;
    private  double salary;
    private  String username;
    private String password;

    public Double getid() {
        return id;
    }

    public void setid(Double id) {
        this.id = id;
    }

    public Employee(Double id, String firstname, String lastname, LocalDate birthdate, String sex, String street, String city, String zip, String country, String email, int telephone, double salary, String username, String password) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public Employee() {

    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
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
}
