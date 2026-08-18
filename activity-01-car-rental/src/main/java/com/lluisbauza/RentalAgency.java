package com.lluisbauza;

import java.util.List;

public class RentalAgency {

    private String name;
    private List<Vehicle> vehicles;

    public RentalAgency() {}

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RentalAgency{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
