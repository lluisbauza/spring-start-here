package com.lluisbauza.activity08productcatalog.bootstrap;

import com.lluisbauza.activity08productcatalog.factory.ProductFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductFactory productFactory;

    public DataInitializer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void run(String... args) throws Exception {

        var product1 = productFactory.createProduct("Laptop", "Office", new BigDecimal("999.99"), 10);
        var product2 = productFactory.createProduct("Phone", "Mobile", new BigDecimal("899.99"), 15);
        var product3 = productFactory.createProduct("Printer", "Office", new BigDecimal("399.99"), 20);


    }
}
