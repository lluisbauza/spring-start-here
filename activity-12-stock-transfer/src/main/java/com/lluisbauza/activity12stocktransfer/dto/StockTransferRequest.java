package com.lluisbauza.activity12stocktransfer.dto;

public record StockTransferRequest(
        Integer sourceStockId,
        Integer destinationStockId,
        Integer quantity) {
}
