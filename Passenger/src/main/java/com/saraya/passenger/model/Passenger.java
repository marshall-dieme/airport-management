package com.saraya.passenger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    @Column(name = "passenger_id", nullable = false)
   private Long   passenger_id;
    @Column(unique = true)
    private int  passport_no;
    private String  firstname;
    private String  lastname;
    private Long  passengerDetailsId;

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public int getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(int passport_no) {
        this.passport_no = passport_no;
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

    public Long getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setPassengerDetailsId(Long passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }
}
