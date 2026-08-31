package com.lluisbauza.activity12stocktransfer.repository;

import com.lluisbauza.activity12stocktransfer.model.WarehouseStock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehouseStockRowMapper implements RowMapper<WarehouseStock> {

    @Override
    public WarehouseStock mapRow(ResultSet rs, int rowNum) throws SQLException {
        WarehouseStock warehouseStock = new WarehouseStock();
        warehouseStock.setId(rs.getInt("id"));
        warehouseStock.setWarehouse(rs.getString("warehouse"));
        warehouseStock.setProduct(rs.getString("product"));
        warehouseStock.setQuantity(rs.getInt("quantity"));
        return warehouseStock;
    }
}
