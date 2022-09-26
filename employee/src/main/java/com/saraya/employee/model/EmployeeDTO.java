package com.saraya.employee.model;

public class EmployeeDTO {
	
	private Long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String birthdate;
	
	private String sex;
	
	private String street;
	
	private String city;
	
	private int zip;
	
	private String country;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private int salary;
	
	private int telephone;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Long employeeId,String firstName, String lastName, String birthdate, String sex, String street, String city, int zip, String country, String email,
			String username, String password, int salary, int telephone) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.sex = sex;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.telephone = telephone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


}
