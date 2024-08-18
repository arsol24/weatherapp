package org.example.entities;

import jakarta.persistence.*;

@Entity
public class CurrentWeather {
    @Id
    private long id;
    private double temp;
    @Column(name = "wind_speed")
    private double windSpeed;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


}
