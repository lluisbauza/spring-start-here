package com.lluisbauza.activity08productcatalog.factory;

import com.lluisbauza.activity08productcatalog.exception.DataOutOfRangeException;
import com.lluisbauza.activity08productcatalog.model.Product;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductFactory {

    private final AtomicInteger count = new AtomicInteger(0);

    public Product createProduct(String name, String category, BigDecimal price, Integer stock) {

        if (price.compareTo(BigDecimal.ZERO) <= 0 || stock < 0 ) {
            throw new DataOutOfRangeException("Price or stock out of range.");
        }

        var product = new Product();

        product.setId((long) count.incrementAndGet());
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setStock(stock);

        return product;
    }
}
