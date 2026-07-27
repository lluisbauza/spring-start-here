package com.lluisbauza.main;

import com.lluisbauza.config.ProjectConfig;
import com.lluisbauza.models.Plant;
import com.lluisbauza.services.PlantCareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var plantCareService = context.getBean(PlantCareService.class);

        var plants = new ArrayList<Plant>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++){
            System.out.print("Introduce plant's name: ");
            String plantName = sc.nextLine();

            System.out.print("Introduce plant's minimum moisture: ");
            int minMoisture = sc.nextInt();

            System.out.print("Introduce plant's maximum moisture: ");
            int maxMoisture = sc.nextInt();

            sc.nextLine();
            System.out.println();

            var plant = new Plant(plantName, plantName, minMoisture, maxMoisture);
            plants.add(plant);
        }

        plants.forEach(plant ->
                System.out.println(plant.getPlantName() + ": " + plantCareService.analyze(plant)));
    }
}
