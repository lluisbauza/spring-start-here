package com.lluisbauza.activity12stocktransfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseStock {

    private Integer id;
    private String warehouse;
    private String product;
    private Integer quantity;

}
