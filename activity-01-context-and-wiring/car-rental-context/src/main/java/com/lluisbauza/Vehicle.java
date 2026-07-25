package com.lluisbauza;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Vehicle {

    private String licensePlate = "9987qwe";
    private String brand = "VW";

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
