package com.lluisbauza.activity08productcatalog.bootstrap;

import com.lluisbauza.activity08productcatalog.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductService productService;

    public DataInitializer(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        productService.createProduct("Laptop", "Office", new BigDecimal("999.99"), 10);
        productService.createProduct("Phone", "Mobile", new BigDecimal("899.99"), 15);
        productService.createProduct("Printer", "Office", new BigDecimal("399.99"), 20);

    }
}
