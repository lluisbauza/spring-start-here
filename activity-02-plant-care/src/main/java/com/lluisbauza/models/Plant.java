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

    public int getMinMoisture() {
        return minMoisture;
    }

    public int getMaxMoisture() {
        return maxMoisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }

    public int getMoisture() {
        return moisture;
    }
}
