package com.saraya.microserviceairplanes.models;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airplane_id", nullable = false)
    private Long airplane_id;

    private int capacity;

    public Airplane() {
    }

    public Airplane(Long airplane_id, int capacity) {
        this.airplane_id = airplane_id;
        this.capacity = capacity;
    }

    public Long getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(Long airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
