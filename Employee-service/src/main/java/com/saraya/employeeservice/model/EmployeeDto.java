package com.saraya.employeeservice.model;


public class EmployeeDto {

    private int employeeId;
    private String firstname;
    private String lastname;
    private String hiredate;
    private String sex;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String telephone;
    private Double salary;
    private String username;
    private String password;

    public EmployeeDto() {
    }

    
	public EmployeeDto(int employeeId, String firstname, String lastname, String hiredate, String sex, String street,
			String city, String zip, String country, String email, String telephone, Double salary, String username,
			String password) {
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.hiredate = hiredate;
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


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
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

	
	
   
}
