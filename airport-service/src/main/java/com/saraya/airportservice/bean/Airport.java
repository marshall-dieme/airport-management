package com.saraya.airportservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Transient
    private static int cpt = 1000;

   @Id
    private String airport_id;

    private boolean iata;

    private boolean icao;

    @Column(unique = true)
    private String name;

    public void generedId(){
        this.airport_id = "AIPRT_" + ++cpt;
    }

    public String getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(String airport_id) {
        this.airport_id = airport_id;
    }

    public boolean isIata() {
        return iata;
    }

    public void setIata(boolean iata) {
        this.iata = iata;
    }

    public boolean isIcao() {
        return icao;
    }

    public void setIcao(boolean icao) {
        this.icao = icao;
    }
}
