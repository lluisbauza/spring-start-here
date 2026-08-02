package com.lluisbauza.sensors;

import com.lluisbauza.models.Plant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("automatic")
public class AutomaticMoistureSensor implements MoistureSensor {

    @Override
    public int getMoisture(Plant plant) {
        //random to simulate reading
        return (int) ((Math.random() * (101)));
    }
}
