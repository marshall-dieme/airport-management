package com.saraya.passagerservice.model;

import javax.persistence.*;

@Entity
public class Passager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passagerId;

    @Column(unique = true)
    private String passportNo;

    private String firstName;

    private String lastName;
    private int passagerDetailsId;

    public int getPassagerDetailsId() {
        return passagerDetailsId;
    }

    public void setPassagerDetailsId(int passagerDetailsId) {
        this.passagerDetailsId = passagerDetailsId;
    }

    public Passager() {
    }

    public int getPassagerId() {
        return passagerId;
    }

    public void setPassagerId(int passagerId) {
        this.passagerId = passagerId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
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


    public Passager(int passagerId, String passportNo, String firstName, String lastName) {
        this.passagerId = passagerId;
        this.passportNo = passportNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
