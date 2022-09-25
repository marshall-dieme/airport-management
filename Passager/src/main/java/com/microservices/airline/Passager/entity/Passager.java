package com.microservices.airline.Passager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Passager {
	
	
	@Id
	private String passagerid;
	
	@Transient
	private static int cpt=0;
	
	@Column(unique = true)
	private String passportno;
	
	private  String firstname;
	
	private String lastname;

	public Passager() {
		super();
	}

	public Passager(String passagerid, String passportno, String firstname, String lastname) {
		super();
		this.passagerid = passagerid;
		this.passportno = passportno;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getPassagerid() {
		return passagerid;
	}

	public void setPassagerid(String passagerid) {
		this.passagerid = passagerid;
	}

	public String getPassportno() {
		return passportno;
	}

	public void setPassportno(String passportno) {
		this.passportno = passportno;
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
	
	
	
	public void generateId() {
		this.passagerid = "passager_id_" + ++cpt;
	}

}
