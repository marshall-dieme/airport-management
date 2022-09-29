package com.saraya.airplaneservice.model;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneId;

    private Long capacity;

    private Long idAirline;

    private Long typeId;
    private Long flightId;



    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}

