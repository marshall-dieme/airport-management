package com.microservices.airplaneairportservices.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_id;

    private String capacity;

    private String idAirline;

    public Airplane() {
    }

    public Airplane(Long airplane_id, String capacity, String idAirline) {
        this.airplane_id = airplane_id;
        this.capacity = capacity;
        this.idAirline = idAirline;
    }

    public Long getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(Long airplane_id) {
        this.airplane_id = airplane_id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(String idAirline) {
        this.idAirline = idAirline;
    }
}
