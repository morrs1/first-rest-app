package com.morrs.firstrestapp.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "scanners_data")
public class ScannersData {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Scanner scanner;

    private double value;

    private boolean raining;

    public UUID getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }
}
