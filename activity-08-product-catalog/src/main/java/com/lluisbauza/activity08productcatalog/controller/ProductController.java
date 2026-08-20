package com.lluisbauza.activity08productcatalog.controller;

import com.lluisbauza.activity08productcatalog.model.Product;
import com.lluisbauza.activity08productcatalog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/api/products", params = "!category")
    public ResponseEntity<List<Product>> getProducts() {

        var products = productService.getProducts();
        int count = products.size();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Product-Count", String.valueOf(count))
                .body(products);
    }


    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {

        var product = productService.getProductById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);

    }

    @GetMapping(value = "/api/products", params = "category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String category) {

        List<Product> productsByCategory = productService.getProductsByCategory(category);

        int count = productsByCategory.size();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Product-Count", String.valueOf(count))
                .body(productsByCategory);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        var createdProduct = productService.createProduct(product.getName(), product.getCategory(), product.getPrice(), product.getStock());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdProduct);

    }

}
