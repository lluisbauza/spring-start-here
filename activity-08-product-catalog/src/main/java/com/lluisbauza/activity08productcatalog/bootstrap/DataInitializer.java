package com.lluisbauza.activity08productcatalog.bootstrap;

import com.lluisbauza.activity08productcatalog.factory.ProductFactory;
import com.lluisbauza.activity08productcatalog.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductFactory productFactory;
    private final ProductService productService;

    public DataInitializer(ProductFactory productFactory,  ProductService productService) {
        this.productFactory = productFactory;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        var product1 = productFactory.createProduct("Laptop", "Office", new BigDecimal("999.99"), 10);
        var product2 = productFactory.createProduct("Phone", "Mobile", new BigDecimal("899.99"), 15);
        var product3 = productFactory.createProduct("Printer", "Office", new BigDecimal("399.99"), 20);

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);

    }
}
