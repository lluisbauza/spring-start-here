package com.lluisbauza.activity08productcatalog.service;

import com.lluisbauza.activity08productcatalog.exception.ProductNotFoundException;
import com.lluisbauza.activity08productcatalog.factory.ProductFactory;
import com.lluisbauza.activity08productcatalog.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final ProductFactory productFactory;

    public ProductService(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        throw new ProductNotFoundException("Product not found.");

    }

    public List<Product> getProductsByCategory(String category) {

        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Product createProduct(String name, String category, BigDecimal price, Integer stock) {

        var createdProduct = productFactory.createProduct(name, category, price, stock);

        products.add(createdProduct);

        return createdProduct;

    }
}
