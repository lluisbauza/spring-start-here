package com.lluisbauza.activity08productcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Product {

    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer stock;

}
