package com.example.kheucha.entities;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="employees")
@Data 
@NoArgsConstructor
@AllArgsConstructor 
 @ToString
 
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
	private Long employee_id;
    @Column(name="firstname")

	private String  firstname;
    @Column(name="lastname")

	private String lastname;
//    @Column(name="birthdate")
//
//	private Date birthdate;
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

	private String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	//   String email1 = "user@domain.com";
//    Boolean email = email1.matches(EMAIL_REGEX);
    @Column(name="telephone")

   private int telephone;
    @Column(name="salary")

   private Double salary;
    @Column(name="username")

   private String username; 
    @Column(name="password")

   private String password;
  

}
