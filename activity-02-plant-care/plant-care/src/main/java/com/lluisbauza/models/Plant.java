package com.lluisbauza.models;

public class Plant {

    private String plantName;
    private int minMoisture;
    private int maxMoisture;
    private int moisture;

    public Plant(String plantName, int minMoisture, int maxMoisture) {
        this.plantName = plantName;
        this.minMoisture = minMoisture;
        this.maxMoisture = maxMoisture;
    }

    public String getPlantName() {
        return plantName;
    }

    public double getMinMoisture() {
        return minMoisture;
    }

    public double getMaxMoisture() {
        return maxMoisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }

    public int getMoisture() {
        return moisture;
    }
}
