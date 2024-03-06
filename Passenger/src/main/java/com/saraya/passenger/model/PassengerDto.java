package com.saraya.passenger.model;

public class PassengerDto {
    private Long   passenger_id;
    private int  passport_no;
    private String  firstname;
    private String  lastname;
    private  String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
