package com.lluisbauza.models;

public class Plant {

    private String plantName;
    private String plantType;
    private double minMoisture;
    private double maxMoisture;

    public Plant(String plantName, String plantType, double minMoisture, double maxMoisture) {
        this.plantName = plantName;
        this.plantType = plantType;
        this.minMoisture = minMoisture;
        this.maxMoisture = maxMoisture;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public double getMinMoisture() {
        return minMoisture;
    }

    public void setMinMoisture(double minMoisture) {
        this.minMoisture = minMoisture;
    }

    public double getMaxMoisture() {
        return maxMoisture;
    }

    public void setMaxMoisture(double maxMoisture) {
        this.maxMoisture = maxMoisture;
    }
}
