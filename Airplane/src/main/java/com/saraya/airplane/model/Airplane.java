package com.saraya.airplane.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Airplane {

    @Id
    @GeneratedValue
    @Column(name = "airplane_id", nullable = false)
    private Long airplane_id;
    private String capacity;
    private Long idAirline;

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

    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }
}
