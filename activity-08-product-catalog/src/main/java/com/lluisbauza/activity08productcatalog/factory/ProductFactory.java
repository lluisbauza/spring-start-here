package com.lluisbauza.activity08productcatalog.factory;

import com.lluisbauza.activity08productcatalog.exception.ProductNotFoundException;
import com.lluisbauza.activity08productcatalog.model.Product;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductFactory {

    private final ObjectProvider<Product> productProvider;
    private final AtomicInteger count = new AtomicInteger(0);

    public ProductFactory(ObjectProvider<Product> productProvider) {
        this.productProvider = productProvider;
    }

    public Product createProduct(String name, String category, BigDecimal price, Integer stock) {

        if (price.compareTo(BigDecimal.ZERO) <= 0 || stock < 0 ) {
            throw new ProductNotFoundException("Price or stock out of range.");
        }

        Product product = productProvider.getObject();

        product.setId((long) count.incrementAndGet());
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setStock(stock);

        return product;
    }
}
