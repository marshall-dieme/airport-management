package com.regulus.passengerdetailservice.dtos;

public class PassengerDetailsDto {

    private int passenger_details_id;

    private String birthDate;

    private String sex;

    private String street;

    private String city;

    private String zip;

    private String country;

    private String email;

    private String telephone;

    private int passenger_id;

    private String passenger_passport_no;

    public PassengerDetailsDto(int passenger_details_id, String birthDate, String sex, String street, String city, String zip, String country, String email, String telephone, int passenger_id, String passenger_passport_no) {
        this.passenger_details_id = passenger_details_id;
        this.birthDate = birthDate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
        this.passenger_id = passenger_id;
        this.passenger_passport_no = passenger_passport_no;
    }

    public PassengerDetailsDto() {
    }

    public int getPassenger_details_id() {
        return passenger_details_id;
    }

    public void setPassenger_details_id(int passenger_details_id) {
        this.passenger_details_id = passenger_details_id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getContry() {
        return country;
    }

    public void setContry(String country) {
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

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_passport_no() {
        return passenger_passport_no;
    }

    public void setPassenger_passport_no(String passenger_passport_no) {
        this.passenger_passport_no = passenger_passport_no;
    }
}
