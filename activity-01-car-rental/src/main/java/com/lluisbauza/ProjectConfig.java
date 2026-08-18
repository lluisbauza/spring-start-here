package com.lluisbauza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.lluisbauza")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle2() {
        var vehicle2 = new Vehicle();
        vehicle2.setLicensePlate("1234LMN");
        vehicle2.setBrand("Audi");
        return vehicle2;
    }

    @Bean
    public RentalAgency rentalAgency(List<Vehicle> vehicles) {
        var rentalAgency = new RentalAgency();
        rentalAgency.setName("Rental Agency");
        rentalAgency.setVehicles(vehicles);
        return rentalAgency;
    }
}
