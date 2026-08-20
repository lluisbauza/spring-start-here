package com.lluisbauza.activity08productcatalog.bootstrap;

import com.lluisbauza.activity08productcatalog.model.Product;
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

        var product1 = new Product("Laptop", "Office", new BigDecimal("999.99"), 10);
        var product2 = new Product("Phone", "Mobile", new BigDecimal("899.99"), 15);
        var product3 = new Product("Printer", "Office", new BigDecimal("399.99"), 20);

        productService.createProduct(product1);
        productService.createProduct(product2);
        productService.createProduct(product3);

    }
}
