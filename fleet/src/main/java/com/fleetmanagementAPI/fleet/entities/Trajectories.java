package com.fleetmanagementAPI.fleet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Trajectories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int taxiId; // Cambiado de taxi_id a taxiId
    private Timestamp date;
    private double latitude;
    private double longitude;

    public Trajectories() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTaxiId() { // Cambiado de getTaxi_id a getTaxiId
        return taxiId;
    }

    public void setTaxiId(int taxiId) { // Cambiado de setTaxi_id a setTaxiId
        this.taxiId = taxiId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
