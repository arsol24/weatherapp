package org.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private double minTemp;
    private double maxTemp;
    private double avgTemp;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

}


