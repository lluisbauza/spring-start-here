package com.lluisbauza.activity12stocktransfer.exception;

public class WarehouseDoesNotExistException extends RuntimeException {
    public WarehouseDoesNotExistException(String message) {
        super(message);
    }
}
