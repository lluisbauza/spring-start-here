package com.lluisbauza;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Vehicle {

    private String licensePlate;
    private String brand;

    @PostConstruct
    public void init() {
        this.licensePlate = "987qwe";
        this.brand = "VW";
    }

    public Vehicle() {
    }

    public Vehicle(String brand, String licensePlate) {
        this.brand = brand;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
