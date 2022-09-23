package com.saraya.passagerservice.model;

public class PassagerDTO {

    private int passagerId;

    private String passportNo;

    private String firstName;

    private String lastName;

    private int passagerDetailsId;

    private String telephone;

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

    public int getPassagerDetailsId() {
        return passagerDetailsId;
    }

    public void setPassagerDetailsId(int passagerDetailsId) {
        this.passagerDetailsId = passagerDetailsId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public PassagerDTO(int passagerId, String passportNo, String firstName, String lastName, int passagerDetailsId) {
        this.passagerId = passagerId;
        this.passportNo = passportNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passagerDetailsId = passagerDetailsId;
    }
}
