package com.saraya.rentalsservice.model;

public class RentalsDTO {

    private int rentalId;

    private String name;

    private String email;

    private String contact;

    private String licenceNo;

    private String pickupDate;

    private String pickupTime;

    private String returnDate;

    private String returnTime;

    private String carNo;

    private int amount;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public RentalsDTO(int rentalId, String name, String email, String contact, String licenceNo, String pickupDate, String pickupTime, String returnDate, String returnTime, String carNo, int amount) {
        this.rentalId = rentalId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.licenceNo = licenceNo;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.carNo = carNo;
        this.amount = amount;
    }
}
