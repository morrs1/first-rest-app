package com.morrs.firstrestapp.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "scanners_data")
public class ScannersData {

    @Id
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "sensor_name", referencedColumnName = "name")
    private Scanner scanner;

    private double value;

    private boolean raining;
}
