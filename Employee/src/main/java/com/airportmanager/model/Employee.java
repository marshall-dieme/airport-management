package com.airportmanager.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long employee_id;
	
	 @Column(name="firstname")
	 private String firstname;
	 @Column(name="lastname")
	 private String lastname;
	 @Column(name="birthday")
	 private LocalDate birthday;
	 @Column(name="sex")
	 private String sex;
	 @Column(name="street")
	 private String street;
	 @Column(name="city")
	 private String city;
	 @Column(name="zip")
	 private String zip;
	 @Column(name="country")
	 private String country;
	 @Column(name="email")
	 private String email;
	 @Column(name="telephone")
	 private int telephone;
	 @Column(name="salary")
	 private double salary;
	 @Column(name="username")
	 private String username;
	 @Column(name="password")
	 private String password;
	 
	 
	 @ManyToMany
	  @JoinTable(name = "employeesevices",
	             joinColumns = @JoinColumn(name = " employee_id "),
	             inverseJoinColumns = @JoinColumn(name = "service_id"))
	  private List<Services> service = new ArrayList<>(); 
	 
	 
	 
	 
	 
	 public Employee() {
		 
	 }
	 
	 
	 
	public Employee(Long employee_id, String firstname, String lastname, LocalDate birthday, String sex, String street,
			String city, String zip, String country, String email, int telephone, double salary, String username,
			String password) {
		super();
		this.employee_id = employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
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
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthday=" + birthday + ", sex=" + sex + ", street=" + street + ", city=" + city + ", zip=" + zip
				+ ", country=" + country + ", email=" + email + ", telephone=" + telephone + ", salary=" + salary
				+ ", username=" + username + ", password=" + password + "]";
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
