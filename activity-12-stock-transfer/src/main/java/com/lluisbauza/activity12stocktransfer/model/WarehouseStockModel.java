package com.lluisbauza.activity12stocktransfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class WarehouseStockModel {

    private Integer id;
    private String warehouse;
    private String product;
    private Integer quantity;

}
