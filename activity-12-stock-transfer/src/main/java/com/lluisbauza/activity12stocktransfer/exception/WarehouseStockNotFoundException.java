package com.lluisbauza.activity12stocktransfer.exception;

public class WarehouseStockNotFoundException extends RuntimeException {
    public WarehouseStockNotFoundException(String message) {
        super(message);
    }
}
