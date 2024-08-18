package org.example.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String region;
    private String country;
    private double lat;
    private double log;

    @OneToOne
    @JoinColumn(name = "current_weather_id")
    private CurrentWeather currentWeather;

    @OneToMany(mappedBy = "location")
    private List<Forecast> forecastList;
}


