package com.tyraka.server.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BODYS")
public class Body {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private float weight;

    @Column(nullable = false)
    private float height;

    @Column(nullable = false)
    private float diameter;

    @Column(nullable = false)
    private String material;

    @JsonIgnore
    @OneToMany(mappedBy = "body", cascade = CascadeType.REMOVE)
    private List<Engine> engines = new ArrayList<Engine>();

    public Body(float weight, float height, float diameter, String material) {
        this.weight = weight;
        this.height = height;
        this.diameter = diameter;
        this.material = material;
    }

    public Body() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
