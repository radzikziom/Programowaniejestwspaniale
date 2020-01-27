package com.tyraka.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ENGINES")
public class Engine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Body body;

    @ManyToOne
    private Plug plug;

    @ManyToOne
    private Nozzle nozzle;

    @ManyToOne
    private Fuel fuel;

    @JsonIgnore
    @OneToMany(mappedBy = "engine", cascade = CascadeType.REMOVE)
    private List<Test> tests = new ArrayList<Test>();

    public Engine(String name, Body body, Plug plug, Nozzle nozzle, Fuel fuel) {
        this.name = name;
        this.body = body;
        this.plug = plug;
        this.nozzle = nozzle;
        this.fuel = fuel;}

    public Engine() {
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plug getPlug() {
        return plug;
    }

    public void setPlug(Plug plug) {
        this.plug = plug;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public void setNozzle(Nozzle nozzle) {
        this.nozzle = nozzle;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
