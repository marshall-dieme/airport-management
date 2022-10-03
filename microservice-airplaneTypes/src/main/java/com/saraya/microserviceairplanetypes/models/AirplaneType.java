package com.saraya.microserviceairplanetypes.models;

import javax.persistence.*;

@Entity
public class AirplaneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airplane_type_id", nullable = false)
    private Long airplane_type_id;
    private String airplane_type_identifier;
    private String description;
    private Long airplineId;

    public AirplaneType() {
    }

    public AirplaneType(Long airplane_type_id, String airplane_type_identifier, String description) {
        this.airplane_type_id = airplane_type_id;
        this.airplane_type_identifier = airplane_type_identifier;
        this.description = description;
    }

    public Long getAirplane_type_id() {
        return airplane_type_id;
    }

    public void setAirplane_type_id(Long airplane_type_id) {
        this.airplane_type_id = airplane_type_id;
    }

    public String getAirplane_type_identifier() {
        return airplane_type_identifier;
    }

    public void setAirplane_type_identifier(String airplane_type_identifier) {
        this.airplane_type_identifier = airplane_type_identifier;
    }

    public String getDescription() {
        return description;
    }

    public Long getAirplineId() {
        return airplineId;
    }

    public void setAirplineId(Long airplineId) {
        this.airplineId = airplineId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
