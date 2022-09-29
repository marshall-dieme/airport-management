package com.regulus.rentalservice.dtos;


public class RentalDto {

    private int rental_id;

    private String name;

    private String email;

    private String contact;

    private String licence_no;

    private String pickup_date;

    private String pickup_time;

    private String return_date;

    private String return_time;

    private String car_no;

    private String amount;

    public RentalDto() {
    }

    public RentalDto(int rental_id, String name, String email, String contact, String licence_no, String pickup_date, String pickup_time, String return_date, String return_time, String car_no, String amount) {
        this.rental_id = rental_id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.licence_no = licence_no;
        this.pickup_date = pickup_date;
        this.pickup_time = pickup_time;
        this.return_date = return_date;
        this.return_time = return_time;
        this.car_no = car_no;
        this.amount = amount;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
