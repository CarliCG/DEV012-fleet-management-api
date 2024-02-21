package com.fleetmanagementAPI.fleet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxis")
public class Taxi {

    @Id
    private Long id;
    private String plate;

    public Taxi(Long id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Taxi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}