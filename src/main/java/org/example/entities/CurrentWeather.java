package org.example.entities;

import jakarta.persistence.*;

@Entity
public class CurrentWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double temp;
    @Column(name = "wind_speed")
    private double windSpeed;

    @OneToOne(mappedBy = "currentWeather")
    private Location location;


}
