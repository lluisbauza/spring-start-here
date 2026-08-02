package com.lluisbauza.config;

import com.lluisbauza.enums.Category;
import com.lluisbauza.model.Technician;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.lluisbauza.model", "com.lluisbauza.service", "com.lluisbauza.factory", "com.lluisbauza.aspect"})
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    Technician Albert() {
        var technician = new Technician();
        technician.setName("Albert");
        technician.setCategory(Category.ACCESS);
        technician.setAvailable(true);
        return technician;
    }

    @Bean
    Technician Hubert() {
        var technician = new Technician();
        technician.setName("Hubert");
        technician.setCategory(Category.HARDWARE);
        technician.setAvailable(true);
        return technician;
    }

    @Bean
    Technician Sonya() {
        var technician = new Technician();
        technician.setName("Sonya");
        technician.setCategory(Category.SOFTWARE);
        technician.setAvailable(true);
        return technician;
    }

}
