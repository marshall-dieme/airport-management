package com.example.airplaneservice.model;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_id;

    private Long capacity;

    private Long idAirline;

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(Long airplane_id) {
        this.airplane_id = airplane_id;
    }

    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }
}
