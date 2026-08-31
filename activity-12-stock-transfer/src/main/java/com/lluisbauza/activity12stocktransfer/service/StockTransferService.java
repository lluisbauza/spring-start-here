package com.lluisbauza.activity12stocktransfer.service;

import com.lluisbauza.activity12stocktransfer.exception.InvalidQuantityException;
import com.lluisbauza.activity12stocktransfer.exception.NotEnoughStockException;
import com.lluisbauza.activity12stocktransfer.dto.StockTransferRequest;
import com.lluisbauza.activity12stocktransfer.exception.SameWarehouseException;
import com.lluisbauza.activity12stocktransfer.exception.WarehouseDoesNotExistException;
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

        return warehouseStockRepository.findById(id)
                .orElseThrow(() ->
                        new WarehouseDoesNotExistException(
                                "Warehouse stock id not found"
                        )
                );
    }

    @Transactional
    public void transfer(StockTransferRequest stockTransferRequest) {

        var sourceStock = getWarehouseStockById(stockTransferRequest.sourceStockId());
        var destinationStock = getWarehouseStockById(stockTransferRequest.destinationStockId());

        if (sourceStock.getId().equals(destinationStock.getId())) {
            throw new SameWarehouseException("Can't transfer stock in the same Warehouse.");
        }

        if (stockTransferRequest.quantity() <= 0) {
            throw new InvalidQuantityException("Quantity should be greater than 0");
        }

        if (stockTransferRequest.quantity() > sourceStock.getQuantity()) {
            throw new NotEnoughStockException("Transfer quantity cannot exceed available stock");
        }

        Integer sourceNewQuantity = sourceStock.getQuantity() - stockTransferRequest.quantity();
        Integer destinationNewQuantity = destinationStock.getQuantity() + stockTransferRequest.quantity();

        warehouseStockRepository.changeStock(sourceStock.getId(), sourceNewQuantity);
        warehouseStockRepository.changeStock(destinationStock.getId(), destinationNewQuantity);

//        Simulate failure to test transaction
//        throw new RuntimeException("Simulated transaction failure");

    }
}
