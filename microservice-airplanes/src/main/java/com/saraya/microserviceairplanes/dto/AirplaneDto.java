package com.saraya.microserviceairplanes.dto;

import java.io.Serializable;

public class AirplaneDto implements Serializable {
    private Long airplane_id;

    private int capacity;

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
