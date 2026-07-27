package com.lluisbauza.services;

import com.lluisbauza.models.Plant;
import com.lluisbauza.sensors.MoistureSensor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlantCareService {

    private final MoistureSensor moistureSensor;

    //No @Autowired needed as there's only a constructor method.
    public PlantCareService(@Qualifier("Automatic") MoistureSensor moistureSensor) {
        this.moistureSensor = moistureSensor;
    }

    public String analyze(Plant plant) {
        int moisture = moistureSensor.getMoisture(plant);
        plant.setMoisture(moisture);

        if (moisture < plant.getMinMoisture()){
            return "Water the plant.";
        } else if (moisture > plant.getMaxMoisture()){
            return "Wait a bit longer.";
        } else {
            return "Check the plant.";
        }

    }

}
