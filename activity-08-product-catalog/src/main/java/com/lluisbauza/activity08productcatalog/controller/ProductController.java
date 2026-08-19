package com.lluisbauza.activity08productcatalog.controller;

import com.lluisbauza.activity08productcatalog.factory.ProductFactory;
import com.lluisbauza.activity08productcatalog.model.Product;
import com.lluisbauza.activity08productcatalog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    private final ProductFactory productFactory;

    public ProductController(ProductService productService, ProductFactory productFactory) {
        this.productService = productService;
        this.productFactory = productFactory;
    }

//    @GetMapping("/api/products")
//    public List<Product> getProducts() {
//        return productService.getProducts();
//    }

    @GetMapping("/api/products")
    public ResponseEntity<List> getProducts() {

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

//    @GetMapping("/api/products")
//    public List<Product> getProductsByCategory(@RequestParam(required = false) String category) {
//        List<Product> productsByCategory = productService.getProductsByCategory(category);
//
//        if (productsByCategory.isEmpty()) {
//            return productService.getProducts();
//        }
//
//        return productsByCategory;
//
//    }

    @GetMapping("/api/products")
    public ResponseEntity<List> getProductsByCategory(@RequestParam(required = false) String category) {

        List<Product> productsByCategory = productService.getProductsByCategory(category);

        if (productsByCategory.isEmpty()) {
            productsByCategory = productService.getProducts();
        }

        int count = productsByCategory.size();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Product-Count", String.valueOf(count))
                .body(productsByCategory);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        var createdProduct = productFactory.createProduct(product.getName(), product.getCategory(), product.getPrice(), product.getStock());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdProduct);

    }

}
