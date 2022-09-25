package com.saraya.microservice.airplaneservice.bean;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private int airplane_id;
    private String airplane_name;
    private String iata;

    public Airplane() {
    }

    public Airplane(int airplane_id, String airplane_name, String iata) {
        this.airplane_id = airplane_id;
        this.airplane_name = airplane_name;
        this.iata = iata;
    }

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public String getAirplane_name() {
        return airplane_name;
    }

    public void setAirplane_name(String airplane_name) {
        this.airplane_name = airplane_name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
