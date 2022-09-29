package com.regulus.passengerservice.dtos;


public class PassengerDto {

    private int passenger_id;

    private String passport_no;

    private String firstName;

    private String lastName;

    private  int booking_id;

    private int booking_seat;

    private int parking_id;

    private String parking_name;

    private int rental_id;

    private String rental_name;

    public PassengerDto() {
    }

    public PassengerDto(int passenger_id, String passport_no, String firstName, String lastName, int booking_id, int booking_seat, int parking_id, String parking_name, int rental_id, String rental_name) {
        this.passenger_id = passenger_id;
        this.passport_no = passport_no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booking_id = booking_id;
        this.booking_seat = booking_seat;
        this.parking_id = parking_id;
        this.parking_name = parking_name;
        this.rental_id = rental_id;
        this.rental_name = rental_name;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
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

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getBooking_seat() {
        return booking_seat;
    }

    public void setBooking_seat(int booking_seat) {
        this.booking_seat = booking_seat;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getParking_name() {
        return parking_name;
    }

    public void setParking_name(String parking_name) {
        this.parking_name = parking_name;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public String getRental_name() {
        return rental_name;
    }

    public void setRental_name(String rental_name) {
        this.rental_name = rental_name;
    }
}
