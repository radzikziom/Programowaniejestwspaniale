package com.tyraka.server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TESTS")
public class Test {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "specific_impuls", nullable = false)
    private float specificImpuls;

    @Column(name = "max_thrust", nullable = false)
    private float maxThrust;

    @Column(name = "burning_time", nullable = false)
    private float burningTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private Engine engine;

    @Column(name = "results_path")
    private String resultsPath;

    public Test(float specificImpuls, float maxThrust, float burningTime, LocalDate date, Engine engine) {
        this.specificImpuls = specificImpuls;
        this.maxThrust = maxThrust;
        this.burningTime = burningTime;
        this.date = date;
        this.engine = engine;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSpecificImpuls() {
        return specificImpuls;
    }

    public void setSpecificImpuls(float specificImpuls) {
        this.specificImpuls = specificImpuls;
    }

    public float getMaxThrust() {
        return maxThrust;
    }

    public void setMaxThrust(float maxThrust) {
        this.maxThrust = maxThrust;
    }

    public float getBurningTime() {
        return burningTime;
    }

    public void setBurningTime(float burningTime) {
        this.burningTime = burningTime;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResultsPath() {
        return resultsPath;
    }

    public void setResultsPath(String resultsPath) {
        this.resultsPath = resultsPath;
    }
}
