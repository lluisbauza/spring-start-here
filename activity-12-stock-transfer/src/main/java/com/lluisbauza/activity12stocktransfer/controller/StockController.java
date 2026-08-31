package com.lluisbauza.activity12stocktransfer.controller;

import com.lluisbauza.activity12stocktransfer.dto.StockTransferRequest;
import com.lluisbauza.activity12stocktransfer.model.WarehouseStock;
import com.lluisbauza.activity12stocktransfer.service.StockTransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    private final StockTransferService stockTransferService;
    public StockController(StockTransferService stockTransferService) {
        this.stockTransferService = stockTransferService;
    }

    @GetMapping("/stocks")
    public List<WarehouseStock> getWarehouseStocks() {
        return stockTransferService.getWarehouseStocks();
    }

    @PostMapping("/stock-transfers")
    public void stockTransfer(@RequestBody StockTransferRequest stockTransferRequest) {
        stockTransferService.transfer(stockTransferRequest);
    }
}
