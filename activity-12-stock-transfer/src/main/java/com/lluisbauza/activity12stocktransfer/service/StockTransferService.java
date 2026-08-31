package com.lluisbauza.activity12stocktransfer.service;

import com.lluisbauza.activity12stocktransfer.dto.StockTransferRequest;
import com.lluisbauza.activity12stocktransfer.model.WarehouseStock;
import com.lluisbauza.activity12stocktransfer.repository.WarehouseStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockTransferService {

    private final WarehouseStockRepository warehouseStockRepository;
    public StockTransferService(WarehouseStockRepository warehouseStockRepository) {
        this.warehouseStockRepository = warehouseStockRepository;
    }

    public List<WarehouseStock> getWarehouseStocks() {
        return warehouseStockRepository.findAll();
    }

    public WarehouseStock getWarehouseStockById(Integer id) {
        return warehouseStockRepository.findById(id);
    }

    @Transactional
    public void transfer(StockTransferRequest stockTransferRequest) {

        var sourceStock = getWarehouseStockById(stockTransferRequest.sourceStockId());
        var destinationStock = getWarehouseStockById(stockTransferRequest.destinationStockId());

        Integer sourceNewQuantity = sourceStock.getQuantity() - stockTransferRequest.quantity();
        Integer destinationNewQuantity = destinationStock.getQuantity() + stockTransferRequest.quantity();

        warehouseStockRepository.changeStock(sourceStock.getId(), sourceNewQuantity);
        warehouseStockRepository.changeStock(destinationStock.getId(), destinationNewQuantity);

    }
}
