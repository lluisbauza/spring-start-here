package com.lluisbauza;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var rentalAgency =  context.getBean(RentalAgency.class);

        System.out.println(rentalAgency);
    }
}
