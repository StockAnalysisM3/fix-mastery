package com.fixmastery.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Capital {

    @Id
    private String state; // no need for a state class
    private String name;
    private long population;
    private double squareMileage;

    private Date created_at;
    private Date updated_at;

    public Capital() {
    }

    public Capital(String stateName, String capitalName, long population, double squareMileage) {
        this.state = stateName;
        this.name = capitalName;
        this.population = population;
        this.squareMileage = squareMileage;
    }

    @PrePersist
    protected void onCreated(){
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdated(){
        this.updated_at = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(double squareMileage) {
        this.squareMileage = squareMileage;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
